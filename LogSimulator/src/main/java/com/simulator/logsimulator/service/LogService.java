package com.simulator.logsimulator.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.*;

@Service
public class LogService {
    /**
     * 업데이트 요망
     * temporaryMap는 임시 DTO
     * <p>
     * 구성 - 필수 Y
     * {
     * type : 로그타입 (Y)
     * s_ip : 출발지 ip (Y)
     * e_ip : 도착지 ip
     * s_time: 발생시간 (Y)
     * e_time: 종료 시간
     * raw : 로그 원본 데이터 (Y)
     * s_country : 출발지 국가 (Y)
     * <p>
     * }
     */
    static List<Map<String, Objects>> temporaryMap = new ArrayList<>();

    // 실행 프로세스
    public static void exec() {
        if (null != temporaryMap && temporaryMap.isEmpty()) {
            CompletableFuture<String> completableFuture = new CompletableFuture<>();
            // 스레드 개수 제한
            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);


            for (Map<String, Objects> data : temporaryMap) {
                CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                    ScheduledFuture<?> scheduledFuture = executorService.scheduleAtFixedRate(() -> {
                        //TODO: 실행 부분
                        //int result = service.performService();
                        //System.out.println("Service performed with result: " + result);
                    }, 0, 3, TimeUnit.SECONDS); // 매 3초마다 실행
                });

            }
        }
    }

    public void service1() {

    }
}
