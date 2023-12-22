package com.simulator.logsimulator.handler;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class CsvReaderTest {
    @Test
    void test1() {
        try {
            CsvReader csvReader = new CsvReader();

            Method executeMethod = CsvReader.class.getDeclaredMethod("execute");

            // execute 메서드 호출
            executeMethod.setAccessible(true); // private 메서드인 경우 접근 가능하게 설정
            executeMethod.invoke(csvReader);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
}