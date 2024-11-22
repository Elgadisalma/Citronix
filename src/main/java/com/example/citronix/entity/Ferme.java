package com.example.citronix.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fermes")
@Getter
@Setter
public class Ferme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String localisation;

    @Column(nullable = false)
    private double superficie;

    @Column(name = "date_creation", nullable = false)
    private LocalDate dateCreation;

    @OneToMany(mappedBy = "ferme")
    private List<Champ> champs;

    public Ferme() {}

    public Ferme(Long id, String nom, String localisation, double superficie, LocalDate dateCreation) {
        this.id = id;
        this.nom = nom;
        this.localisation = localisation;
        this.superficie = superficie;
        this.dateCreation = dateCreation;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setChamps(List<Champ> champs) {
        this.champs = champs;
    }

    public List<Champ> getChamps() {
        if (champs == null) {
            champs = new ArrayList<>();
        }
        return champs;
    }
}