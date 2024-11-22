package com.example.citronix.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "arbres")
@Getter
@Setter
public class Arbre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private LocalDate datePlantation;

    @ManyToOne
    @JoinColumn(name = "id_champ", nullable = false)
    private Champ champ;

    public int getAge() {
        return Period.between(datePlantation, LocalDate.now()).getYears();
    }

    public double getProductiviteAnnuelle() {
        int age = getAge();
        if (age < 3) {
            return 2.5;
        } else if (age <= 10) {
            return 12.0;
        } else {
            return 20.0;
        }
    }

}
