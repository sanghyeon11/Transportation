package org.logSimulator.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoggerService {

    @Scheduled(fixedDelayString = "${log.cycle}")
    private void LogWriter() {
        log.info("zz");
    }
}
