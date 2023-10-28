package com.simulator.logsimulator.job;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.*;

class FileJobTest {
    @Test
    public void test() {
        String filePath = "/Users/jeongsanghyeon/test/logs/test.log"; // 읽을 파일 경로

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // 파일에서 한 줄씩 읽어옴
                System.out.println(line); // 읽은 내용을 출력하거나 다른 작업 수행
                test2();
                // 만약 CSV 파일이라면, CSV 데이터를 파싱하거나 처리할 수 있습니다.
            }


            bufferedReader.close(); // 파일과 연결된 리더 닫기
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        String filePath = "/Users/jeongsanghyeon/test/logs/test.log"; // 읽을 파일 경로

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // 파일에서 한 줄씩 읽어옴
                System.out.println(line); // 읽은 내용을 출력하거나 다른 작업 수행

                // 만약 CSV 파일이라면, CSV 데이터를 파싱하거나 처리할 수 있습니다.
            }

            bufferedReader.close(); // 파일과 연결된 리더 닫기
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}