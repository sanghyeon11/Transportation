package com.simulator.logsimulator.handler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface LogReaderFactory {
    Map<String, JSONArray> execute();

    static JSONArray readCSV(String filePath) {
        JSONArray records = new JSONArray();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), "EUC-KR"))) {
            String line;
            int cnt = 0;
            String[] fields = null;
            while ((line = br.readLine()) != null) {
                JSONObject jsonObject = new JSONObject();
                if (cnt == 0) {
                    // line이 한 줄 ( 구분자 \n )
                 fields = line.split(",");
                 cnt ++;
                 continue;
                }
                String[] values = line.split(",");

                for (int i=0; i < fields.length; i++) {
                    jsonObject.put(fields[i], values[i]);
                }
                records.put(jsonObject);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    static String replaceKey(String input) {
        String patternString = "\\(([^)]+)\\)";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

    static String replaceValue(String input) {
        if (input.charAt(0) == '"') {
            input = input.substring(1, input.length()-2);
        }
        return input;
    }

}
