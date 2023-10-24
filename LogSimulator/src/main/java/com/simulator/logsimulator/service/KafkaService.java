package com.simulator.logsimulator.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class KafkaService {
    private final Producer<String, String> kafkaProducer;

    @Autowired
    public KafkaService(Producer<String, String> kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    public void sendMessage(String topic, String key, String value) {
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);
        kafkaProducer.send(record, (metadata, exception) -> {
            if (exception == null) {
                log.info("메시지 전송 완료. Offset: - {}", metadata.offset());
            } else {
                log.error("메시지 전송 실패: - {}", exception.getMessage());
            }
        });
    }
}
