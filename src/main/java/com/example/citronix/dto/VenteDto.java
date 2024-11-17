package com.example.citronix.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VenteDto {
    private Long id;
    private LocalDate dateVente;
    private double prixUnitaire;
    private String client;
    private double quantite;
    private Long idRecolte;
}
