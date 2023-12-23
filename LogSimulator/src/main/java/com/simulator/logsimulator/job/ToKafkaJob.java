package com.simulator.logsimulator.job;

import com.simulator.logsimulator.handler.CsvReader;
import com.simulator.logsimulator.service.KafkaService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class ToKafkaJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("### Hello Job is being executed!");
        KafkaService kafkaService = new KafkaService();
        CsvReader csvReader = new CsvReader();
        Map<String, JSONArray> map = csvReader.execute();
        if (null != map) {
            for (Map.Entry<String, JSONArray> entry : map.entrySet()) {
                String topic = entry.getKey();
                JSONArray value = entry.getValue();

                for (Object obj : value) {
                    if (obj instanceof JSONObject jsonObject)
                        kafkaService.sendMessage(topic, topic, jsonObject.toString());
                }
            }
        }
    }
}
