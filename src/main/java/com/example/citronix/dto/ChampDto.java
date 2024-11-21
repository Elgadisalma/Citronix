package com.example.citronix.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChampDto {
    private Long id;

    @NotNull(message = "La superficie est obligatoire.")
    @DecimalMin(value = "0.1", inclusive = true, message = "La superficie doit être supérieure ou égale à 0.1")
    private double superficie;

    @NotNull(message = "L'ID de la ferme est obligatoire.")
    private Long idFerme;

    private List<Long> idArbres;

    // Getters
    public Long getId() {
        return id;
    }

    public double getSuperficie() {
        return superficie;
    }

    public Long getIdFerme() {
        return idFerme;
    }

    public List<Long> getIdArbres() {
        return idArbres;
    }
}
