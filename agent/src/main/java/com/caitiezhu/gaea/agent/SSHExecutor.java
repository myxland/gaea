package com.caitiezhu.gaea.agent;

import com.caitiezhu.gaea.agent.module.Remote;
import com.jcraft.jsch.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SSHExecutor {

    public static Session getSession(Remote remote) throws JSchException {
        JSch jSch = new JSch();
        Session session = jSch.getSession(remote.getUser(), remote.getHost(),remote.getPort());
        session.setPassword(remote.getPassword());
        session.setConfig("StrictHostKeyChecking", "no");
        return session;
    }

    public static List<String> remoteExecute(Session session, String command) throws JSchException {
        log.debug(">> {}", command);
        List<String> resultLines = new ArrayList<>();
        ChannelExec channel = null;
        try{
            channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand(command);
            InputStream input = channel.getInputStream();
            channel.connect();
            try {
                BufferedReader inputReader = new BufferedReader(new InputStreamReader(input));
                String inputLine = null;
                while((inputLine = inputReader.readLine()) != null) {
                    log.debug("   {}", inputLine);
                    resultLines.add(inputLine);
                }
            } finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (Exception e) {
                        log.error("JSch inputStream close error:", e);
                    }
                }
            }
        } catch (IOException e) {
            log.error("IOcxecption:", e);
        } finally {
            if (channel != null) {
                try {
                    channel.disconnect();
                } catch (Exception e) {
                    log.error("JSch channel disconnect error:", e);
                }
            }
        }
        return resultLines;
    }

    public static void upLoadFile(Session session, String sPath, String dPath) {

        Channel channel = null;
        try {
            channel = (Channel) session.openChannel("sftp");
            channel.connect(10000000);
            ChannelSftp sftp = (ChannelSftp) channel;
            try {
                sftp.cd(dPath);
            } catch (SftpException e) {
                sftp.mkdir(dPath);
                sftp.cd(dPath);
            }
            File file = new File(sPath);
            copyFile(sftp, file, sftp.pwd());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            channel.disconnect();
        }
    }

    private static void copyFile(ChannelSftp sftp, File file, String pwd) {

        if (file.isDirectory()) {
            File[] list = file.listFiles();
            try {
                try {
                    String fileName = file.getName();
                    sftp.cd(pwd);
//                    System.out.println("正在创建目录:" + sftp.pwd() + "/" + fileName);
                    sftp.mkdir(fileName);
//                    System.out.println("目录创建成功:" + sftp.pwd() + "/" + fileName);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                pwd = pwd + "/" + file.getName();
                try {

                    sftp.cd(file.getName());
                } catch (SftpException e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            for (int i = 0; i < list.length; i++) {
                copyFile(sftp, list[i], pwd);
            }
        } else {

            try {
                sftp.cd(pwd);

            } catch (SftpException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
//            System.out.println("正在复制文件:" + file.getAbsolutePath());
            InputStream instream = null;
            OutputStream outstream = null;
            try {
                outstream = sftp.put(file.getName());
                instream = new FileInputStream(file);

                byte b[] = new byte[1024];
                int n;
                try {
                    while ((n = instream.read(b)) != -1) {
                        outstream.write(b, 0, n);
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            } catch (SftpException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                try {
                    outstream.flush();
                    outstream.close();
                    instream.close();

                } catch (Exception e2) {
                    // TODO: handle exception
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Remote remote = new Remote();
        Session session = getSession(remote);
        session.connect();
        if (session.isConnected()) {
            log.debug("Host({}) connected.", remote.getHost());
        }
        upLoadFile(session, "/Users/caitiezhu/IdeaProjects/gaea/agent", "/root/jsch-demo/");
        session.disconnect();
    }
}
