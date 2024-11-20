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

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public LocalDate getDatePlantation() {
//        return datePlantation;
//    }
//
//    public void setDatePlantation(LocalDate datePlantation) {
//        this.datePlantation = datePlantation;
//    }
//
//    public Long getIdChamp() {
//        return idChamp;
//    }
//
//    public void setIdChamp(Long idChamp) {
//        this.idChamp = idChamp;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public double getProductiviteAnnuelle() {
//        return productiviteAnnuelle;
//    }
//
//    public void setProductiviteAnnuelle(double productiviteAnnuelle) {
//        this.productiviteAnnuelle = productiviteAnnuelle;
//    }
}
