package org.main.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

@Configuration
public class AppConfig {
    @Bean
    public Properties applicationProperties() throws IOException {
        ClassPathResource resource = new ClassPathResource(
                "/Users/jeongsanghyeon/workspace/Transportation/CoreModule/" +
                        "src/main/resources/local/application.properties");
        Properties properties = new Properties();
        PropertiesLoaderUtils.fillProperties(properties, resource);
        return properties;
    }
}
