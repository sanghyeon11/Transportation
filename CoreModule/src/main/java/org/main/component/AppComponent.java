package org.main.component;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class AppComponent {

    private final Properties applicationProperties;

    @Autowired
    public AppComponent(Properties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    public String getProperty(String key) {
        return applicationProperties.getProperty(key);
    }
}
