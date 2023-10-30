package com.simulator.logsimulator.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Slf4j
@Service
public class KafkaService {
    private final Producer<String, String> kafkaProducer;
    private final AdminClient topicMaker;

    @Autowired
    public KafkaService(Producer<String, String> kafkaProducer, AdminClient topicMaker) {
        this.kafkaProducer = kafkaProducer;
        this.topicMaker = topicMaker;
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

    public boolean createTopic(String topicName) {
        // 토픽 이름, 파티션 수, 리플리케이션 팩터 설정
        int numPartitions = 3;
        short replicationFactor = 1; // 리플리케이션 팩터 (브로커 수에 따라 조정)

        // 토픽 생성
        NewTopic newTopic = new NewTopic(topicName, numPartitions, replicationFactor);
        topicMaker.createTopics(Collections.singletonList(newTopic));

        log.info("Create Topic - {}", topicName);
        return true;
    }
}
