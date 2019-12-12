package com.caitiezhu.gaea.gitlab.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Executor {

    public static List<String> exec(String command) throws IOException {
        List<String> result = new ArrayList<>();
        Process process = Runtime.getRuntime().exec(command);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))){
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(line.trim());
            }
        }
        return result;
    }
}
