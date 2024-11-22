package com.example.citronix.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ArbreDto {
    private Long id;

    @NotBlank(message = "Le type d'arbre est obligatoire.")
    private String type;

    @NotNull(message = "La date de plantation est obligatoire.")
    private LocalDate datePlantation;

    @NotNull(message = "L'ID du champ est obligatoire.")
    private Long idChamp;

    private int age;
    private double productiviteAnnuelle;

}
