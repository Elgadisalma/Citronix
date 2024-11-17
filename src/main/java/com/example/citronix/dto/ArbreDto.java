package com.example.citronix.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDate;

@Getter
@Setter
public class ArbreDto {
    private Long id;
    private LocalDate datePlantation;
    private Duration age;
    private Long idChamp;
}
