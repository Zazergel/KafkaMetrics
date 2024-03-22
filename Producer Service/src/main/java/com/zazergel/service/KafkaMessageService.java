package com.zazergel.service;

import com.zazergel.model.Metric;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageService {
    @Value("${topic.metrics}")
    private String metricsTopic;
    private final KafkaTemplate<String, Metric> kafkaTemplate;

    public KafkaMessageService(KafkaTemplate<String, Metric> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Metric metric) {
        log.info("Send message -> {}", metric);
        this.kafkaTemplate.send(metricsTopic, metric);
    }

}
