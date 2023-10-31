package com.example.preprocessing.configuration;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.Properties;

@Configuration
public class KafkaConfig {
    /**
     * 프로듀서 애플리케이션에서는 데이터를 전달할 브로커의 호스트 ip와 토픽명을 알고 있어야 한다.
     * [참고] 브로커에 해당 토픽명이 없는 경우에는 기본 설정에 따라서는 토픽을 생성하고 데이터를 넣어준다.
     */
    private final static String BOOTSTRAP_SERVER = "localhost:9092";
    private final static String TOPIC_NAME = "custom_topic";
    @Bean
    public KafkaProducer<String, String> producer() {
        /**
         * 프로듀서의 인스턴스에 사용할 '필수 옵션'을 설정한다.
         * [참고] 선언하지 않은 '선택 옵션'은 기본 옵션값으로 설정되어 동작한다.
         */
        Properties configs = new Properties();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);

        /**
         * 메시지 키, 값을 직렬화 하기 위해 StringSerializer를 사용한다.
         * StringSerializer는 String을 직렬화하는 카프카의 라이브러리이다.
         * (org.apache.kafka.common.serialization)
         *
         * CustomPartitioner는 프로듀서 애플리케이션이 메시지를 전달할 때, 파티션을 고르는데 사용할 파티셔너이다.
         */
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //TODO: 파티션 사용 가능한 부분인지 확인
        //configs.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, CustomPartitioner.class);

        /**
         * 프로듀서 인스턴스를 생성하며, 위에서 설정한 설정을 파라미터로 사용한다.
         */
//        KafkaProducer<String, String> producer = new KafkaProducer<>(configs);
//        return producer;
        return new KafkaProducer<>(configs);
    }
    // bean으로 필요성이 있는지 고민
    @Bean
    public KafkaConsumer<String, String> consumer() {
        Properties props = new Properties();

        // kafka server host 및 port 설정
        props.put("bootstrap.servers", BOOTSTRAP_SERVER);
        props.put("group.id", "karim-group-id-1"); // group-id 설정
        //props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        //props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer"); // key deserializer
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer"); // value deserializer
        return new KafkaConsumer<>(props);
        // consumer 생성
        //KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        // topic 설정
        //props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());consumer.subscribe(Collections.singletonList(TOPIC_NAME));

//        try {
//            while (true) {
//                // 계속 loop를 돌면서 producer의 message를 띄운다.
//                ConsumerRecords<String, String> records = consumer.poll(100);
//                for (ConsumerRecord<String, String> record : records)
//                    System.out.println(record.value());
//            }
//        } catch (Exception e) {
//        } finally {
//            consumer.close();
//        }
    }
}
