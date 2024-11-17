package com.example.citronix.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDate;

@Entity
@Table(name = "arbres")
@Getter
@Setter
public class Arbre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_plantation", nullable = false)
    private LocalDate datePlantation;

    @Column(nullable = false)
    private Duration age;

    @ManyToOne
    @JoinColumn(name = "id_champ", nullable = false)
    private Champ champ;
}