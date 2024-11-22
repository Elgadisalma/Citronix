package com.example.citronix.dto;

import jakarta.validation.constraints.*;

import lombok.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FermeDto {
    private Long id;

    @NotBlank(message = "Le nom de la ferme est obligatoire.")
    @Size(max = 50, message = "Le nom ne peut pas dépasser 50 caractères.")
    private String nom;

    @NotBlank(message = "La localisation est obligatoire.")
    private String localisation;

    @NotNull(message = "La superficie est obligatoire.")
    @DecimalMin(value = "0.1", inclusive = true, message = "La superficie doit être supérieure ou égale à 0.1")
    private double superficie;

    @NotNull(message = "La date de création est obligatoire.")
    private LocalDate dateCreation;

    private List<Long> idChamps;

    public FermeDto(Long id, String nom, String localisation, Double superficie, LocalDate dateCreation) {
        this.id = id;
        this.nom = nom;
        this.localisation = localisation;
        this.superficie = superficie;
        this.dateCreation = dateCreation;
    }
    // Getters
    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getLocalisation() {
        return localisation;
    }

    public double getSuperficie() {
        return superficie;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public List<Long> getIdChamps() {
        return idChamps;
    }
}
