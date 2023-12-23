package com.transprotation.analyzer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Slf4j
@Service
public class ClickHouseService {

    private final Connection clickHouseConnection;

    @Autowired
    public ClickHouseService(Connection clickHouseConnection) {
        this.clickHouseConnection = clickHouseConnection;
    }

    public void insert(String query, String ... params ) {
        try (PreparedStatement preparedStatement = clickHouseConnection.prepareStatement(query)) {
            int cnt = 1;
            for (String param : params) {
                preparedStatement.setString(cnt, param);
                cnt++;
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
