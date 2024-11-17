package com.example.citronix.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "recoltes")
@Getter
@Setter
public class Recolte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Saison saison;

    @Column(name = "date_recolte", nullable = false)
    private LocalDate dateRecolte;

    @Column(nullable = false)
    private double quantite;

    @OneToMany(mappedBy = "recolte")
    private List<DetailRecolte> detailsRecolte;
}