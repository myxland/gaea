package com.caitiezhu.gaea.agent;

import com.jcraft.jsch.*;

import java.util.Properties;

public class ChannelSftpSingleton {
    private static ChannelSftpSingleton instance;
    private ChannelSftp channelSftp;
    private Session session;

    private ChannelSftpSingleton() {
    }

    public static ChannelSftpSingleton getInstance() {
        if (instance == null) {
            instance = new ChannelSftpSingleton();
        }
        return instance;
    }

    public ChannelSftp getChannelSftp() throws JSchException {
        if (channelSftp != null) {
            return channelSftp;
        }
        channelSftp = getChannel();
        return channelSftp;
    }

    /**
     * 断开SFTP Channel、Session连接
     *
     * @throws Exception
     */
    public void closeChannel() throws Exception {
        if (channelSftp != null) {
            channelSftp.disconnect();
        }
        if (session != null) {
            session.disconnect();
        }
        System.out.println("disconnected SFTP successfully!");
    }

    /**
     * 获得SFTP Channel
     *
     * @return ChannelSftp Instance
     * @throws JSchException
     */
    private ChannelSftp getChannel() throws JSchException {
        String host = "120.**.***.***";
        int port = 22;
        String userName = "root";
        String password = "123456";
        // 创建JSch对象
        JSch jsch = new JSch();
        // 根据用户名，主机ip，端口获取一个Session对象
        session = jsch.getSession(userName, host, port);
        // 设置密码
        session.setPassword(password);
        Properties configTemp = new Properties();
        configTemp.put("StrictHostKeyChecking", "no");
        // 为Session对象设置properties
        session.setConfig(configTemp);
        // 设置timeout时间
        session.setTimeout(60000);
        session.connect();
        // 通过Session建立链接
        // 打开SFTP通道
        Channel channel = session.openChannel("sftp");
        // 建立SFTP通道的连接
        channel.connect();
        System.out.println("Connected successfully to ftpHost = " + host + ",as ftpUserName = " + userName + ", returning: " + channel);
        return (ChannelSftp) channel;
    }
}
