package com.caitiezhu.gaea.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "demo.sh";
        StringBuilder builder = new StringBuilder()
                .append("/Users").append("/caitiezhu").append("/IdeaProjects")
                .append("/gaea").append("/service").append("/").append(fileName);

        File file = new File(builder.toString());
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter writer = new FileWriter(file);
        BufferedWriter bufferWritter = new BufferedWriter(writer);

        bufferWritter.write(commands.toString());
        bufferWritter.close();
    }

    private static final StringBuilder commands = new StringBuilder();

    static {
        commands.append("#!/usr/bin/env bash\n");
        commands.append("cd /root/demo\n");
        commands.append("mvn clean package\n");
        commands.append("cd target\n");
        commands.append("nohup java -jar *.jar &\n");
    }
}
