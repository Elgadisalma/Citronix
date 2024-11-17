package com.example.citronix.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetailRecolteDto {
    private Long id;
    private double quantite;
    private Long idArbre;
    private Long idRecolte;
}
