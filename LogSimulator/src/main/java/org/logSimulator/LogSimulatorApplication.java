package org.logSimulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@PropertySource(value = {"classpath:local/Application.properties"},
        ignoreResourceNotFound = true)
public class LogSimulatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogSimulatorApplication.class, args);
    }
}
