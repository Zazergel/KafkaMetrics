package com.zazergel.controller;

import com.zazergel.model.MetricDto;
import com.zazergel.service.MetricService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MetricController {

    private final MetricService metricService;

    @Autowired
    public MetricController(MetricService metricService) {
        this.metricService = metricService;
    }

    @PostMapping("/metric")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Object> sendMessage(@Valid @RequestBody MetricDto metricDto) {
        return metricService.validMetricName(metricDto);
    }
}
