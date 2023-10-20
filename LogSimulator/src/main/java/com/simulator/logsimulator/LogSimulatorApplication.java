package com.simulator.logsimulator;

import com.simulator.logsimulator.job.ToKafkaJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.JobBuilder.newJob;

@SpringBootApplication
public class LogSimulatorApplication {

    public static void main(String[] args) throws SchedulerException, InterruptedException {

        JobDetail jobDetail = newJob(ToKafkaJob.class)
                .withIdentity("ToKafkaJob")
                .build();

        // 실행 시점을 결정하는 Trigger 생성
        Trigger trigger = newTrigger()
                .withIdentity("ToKafkaJob")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(1)
                        .repeatForever())
                .startNow()
                .build();

        // 스케줄러 실행 및 JobDetail과 Trigger 정보로 스케줄링
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
        Thread.sleep(1000);  // Job이 실행될 수 있는 시간 여유를 준다

        // 스케줄러 종료
        //scheduler.shutdown(true);


        SpringApplication.run(LogSimulatorApplication.class, args);
    }

}
