package com.example.citronix.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ChampDto {
    private Long id;
    private double superficie;
    private Long idFerme;
    private List<Long> idArbres;
}
