package com.zazergel.service;

import com.zazergel.model.Metric;
import com.zazergel.repository.MetricRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MetricService {

    private final MetricRepository metricRepository;

    @Autowired
    public MetricService(MetricRepository metricRepository) {
        this.metricRepository = metricRepository;
    }

    public List<Metric> getAll() {
        log.info("Вывод всех метрик");
        return metricRepository.findAll();
    }

    public Optional<Metric> getMetricById(Long id) {
        log.info("Получение метрики с Id: " + id);
        return metricRepository.findById(id);
    }

    public void saveMetric(Metric metric) {
        log.info("Сохранение метрики в базу данных. Метрика: " + metric.toString());
        metricRepository.save(metric);
    }
}
