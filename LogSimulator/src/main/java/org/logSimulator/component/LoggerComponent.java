package org.logSimulator.component;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import java.util.Properties;

@Log4j2
@Configuration
public class LoggerComponent {

    @Value("${test}")
    String a;

    @Bean
    public void test() {
      log.info("a");
    }

}
