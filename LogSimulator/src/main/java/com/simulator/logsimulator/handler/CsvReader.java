package com.simulator.logsimulator.handler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.Objects;

public class CsvReader implements LogReaderFactory{
    @Override
    public JSONArray execute() {
        JSONArray records = LogReaderFactory.readCSV("/Users/jeongsanghyeon/test/logs/bus_data_sample.csv");

        for (Object obj : records) {
            if (obj instanceof JSONObject) {
                JSONObject record = (JSONObject) obj;

                // JSONObject의 키와 값을 출력 (원하는 작업 수행)
                for (String key : record.keySet()) {
                    String value = record.getString(key);
                    System.out.println(key + ": " + value);
                }
                System.out.println();
            }
        }
        return null;
    }
}
