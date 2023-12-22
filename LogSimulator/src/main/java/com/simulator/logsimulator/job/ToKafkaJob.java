package com.simulator.logsimulator.job;

import com.simulator.logsimulator.service.KafkaService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ToKafkaJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("### Hello Job is being executed!");
        KafkaService kafkaService = new KafkaService();
        kafkaService.sendMessage("your-topic", "your-key", "your-message");
    }
}
