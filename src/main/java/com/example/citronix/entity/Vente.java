package com.example.citronix.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "ventes")
@Getter
@Setter
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_vente", nullable = false)
    private LocalDate dateVente;

    @Column(name = "prix_unitaire", nullable = false)
    private double prixUnitaire;

    @Column(nullable = false)
    private String client;

    @Column(nullable = false)
    private double quantite;

    @ManyToOne
    @JoinColumn(name = "id_recolte", nullable = false)
    private Recolte recolte;
}