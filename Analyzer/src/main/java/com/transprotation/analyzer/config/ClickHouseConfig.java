package com.transprotation.analyzer.config;

import com.clickhouse.jdbc.ClickHouseDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
public class ClickHouseConfig {
    String url = "jdbc:clickhouse://localhost:8123/default";
    String user = "test";
    String password = "1234";

    @Bean
    public Connection clickHouseConnection() throws SQLException {

        Properties properties = new Properties();

        ClickHouseDataSource dataSource = new ClickHouseDataSource(url, properties);
        Connection conn = dataSource.getConnection(user, password);
        return conn;
    }
}
