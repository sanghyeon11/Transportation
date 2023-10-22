package com.simulator.logsimulator.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Value;

import java.util.Properties;

import static org.main.util.FileUtils.CreateFile;

@Slf4j
public class FileJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        CreateFile("/Users/jeongsanghyeon/test/logs/");
    }
}
