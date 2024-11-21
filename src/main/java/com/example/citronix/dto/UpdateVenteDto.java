package com.example.citronix.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateVenteDto {

    @NotNull(message = "La date de vente est obligatoire.")
    @FutureOrPresent(message = "La date de vente doit être aujourd'hui ou dans le futur.")
    private LocalDate dateVente;

    @NotNull(message = "Le prix unitaire est obligatoire.")
    @Positive(message = "Le prix unitaire doit être un nombre positif.")
    private double prixUnitaire;

    @NotBlank(message = "Le nom du client est obligatoire.")
    @Size(max = 100, message = "Le nom du client ne doit pas dépasser 100 caractères.")
    private String client;
}
