package com.example.citronix.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "details_recolte")
@Getter
@Setter
public class DetailRecolte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double quantite;

    @ManyToOne
    @JoinColumn(name = "id_arbre", nullable = false)
    private Arbre arbre;

    @ManyToOne
    @JoinColumn(name = "id_recolte", nullable = false)
    private Recolte recolte;
}