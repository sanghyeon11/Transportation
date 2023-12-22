package com.simulator.logsimulator.handler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface LogReaderFactory {
    JSONArray execute();

    static JSONArray readCSV(String filePath) {
        JSONArray records = new JSONArray();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), "EUC-KR"))) {
            String line;
            JSONObject jsonObject = new JSONObject();
            int cnt = 0;
            String[] fields = null;
            while ((line = br.readLine()) != null) {
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
}
