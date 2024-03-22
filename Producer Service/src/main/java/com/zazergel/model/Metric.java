package com.zazergel.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
public class Metric {

    private String name;
    private double maxMemory;
    private double usedMemory;
    private LocalDateTime created;
}
