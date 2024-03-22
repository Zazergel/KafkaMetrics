package com.zazergel.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MetricDto {

    @NotBlank(message = "Имя метрики не может быть пустым!")
    private String name;
}
