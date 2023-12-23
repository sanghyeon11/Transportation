package com.simulator.logsimulator.handler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CsvReader implements LogReaderFactory{
    @Override
    public Map<String, JSONArray> execute() {
        Map<String, JSONArray> map = new HashMap<>();
        JSONArray dataArr = new JSONArray();
        JSONArray records = LogReaderFactory.readCSV("/Users/jeongsanghyeon/test/logs/bus_data_sample.csv");

        for (Object obj : records) {
            if (obj instanceof JSONObject record) {
                JSONObject formatData = new JSONObject();
                // JSONObject의 키와 값을 출력 (원하는 작업 수행)
                for (String key : record.keySet()) {
                    formatData.put(LogReaderFactory.replaceKey(key), LogReaderFactory.replaceValue(record.getString(key)));
                }
                dataArr.put(formatData);
            }
        }
        map.put("bus", dataArr);
        return map;
    }
}
