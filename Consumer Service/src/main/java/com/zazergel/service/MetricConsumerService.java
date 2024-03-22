package com.zazergel.service;

import com.zazergel.model.Metric;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MetricConsumerService {
    private final MetricService metricService;

    @Autowired
    public MetricConsumerService(MetricService metricService) {
        this.metricService = metricService;
    }

    @KafkaListener(topics = "metrics-topic", groupId = "metrics_group")
    public void listen(Metric metric) {
        log.info("Из Kafka получена новая метрика: " + metric.toString());
        metricService.saveMetric(metric);
    }
}
