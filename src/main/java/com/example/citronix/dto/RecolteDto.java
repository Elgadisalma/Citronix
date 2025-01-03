package com.example.citronix.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class RecolteDto {
    private Long id;

    @NotNull(message = "La saison est obligatoire.")
    private String saison;

    @NotNull(message = "La date est obligatoire.")
    private LocalDate dateRecolte;

    @NotNull(message = "La quantite est obligatoire.")
    @Positive(message = "La quantité doit être un nombre positif.")
    private double quantite;

    @NotNull(message = "Le champ est obligatoire.")
    private Long champId;

    private List<Long> idDetailsRecolte;
}

