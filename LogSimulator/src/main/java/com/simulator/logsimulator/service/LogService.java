package com.simulator.logsimulator.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.*;

@Service
public class LogService {
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
