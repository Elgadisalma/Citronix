package com.example.citronix.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class RecolteDto {
    private Long id;
    private String saison;
    private LocalDate dateRecolte;
    private double quantite;
    private List<Long> idDetailsRecolte;
}
