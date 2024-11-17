package com.example.citronix.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "champs")
@Getter
@Setter
public class Champ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double superficie;

    @ManyToOne
    @JoinColumn(name = "id_ferme", nullable = false)
    private Ferme ferme;

    @OneToMany(mappedBy = "champ")
    private List<Arbre> arbres;
}