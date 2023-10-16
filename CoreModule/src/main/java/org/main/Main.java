package org.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@PropertySource(value = {"classpath:local/application.properties"},
        ignoreResourceNotFound = true)
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}