package com.zazergel.service;

import com.zazergel.model.Metric;
import com.zazergel.model.MetricDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

@Service
@Slf4j
public class MetricService {
    private final KafkaMessageService kafkaMessageService;

    @Autowired
    public MetricService(KafkaMessageService kafkaMessageService) {
        this.kafkaMessageService = kafkaMessageService;
    }

    private ResponseEntity<Object> sendToKafka(Metric metric) {
        try {
            kafkaMessageService.sendMessage(metric);
            return ResponseEntity.ok().body("Метрика успешно отправлена: " + metric);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    public ResponseEntity<Object> validMetricName(MetricDto metricDto) {
        if (metricDto.getName().equalsIgnoreCase("memory")) {
            return createMemoryMetric();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Неподдерживаемое имя метрики");
        }
    }

    private ResponseEntity<Object> createMemoryMetric(){
        log.info("Запись значений памяти для метрики c именем: Memory");
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();

        DecimalFormat df = new DecimalFormat("#.###");

        double maxHeapMemory = Double.parseDouble(df.format(heapMemoryUsage.getMax() / (1024.0 * 1024.0)));
        double usedHeapMemory = Double.parseDouble(df.format(heapMemoryUsage.getUsed() / (1024.0 * 1024.0)));

        Metric metric = Metric.builder()
                .name("Memory")
                .maxMemory(maxHeapMemory)
                .usedMemory(usedHeapMemory)
                .created(LocalDateTime.now())
                .build();

        return sendToKafka(metric);
    }


}
