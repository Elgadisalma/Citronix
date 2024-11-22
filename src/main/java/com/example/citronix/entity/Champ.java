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

    @OneToMany(mappedBy = "champ", cascade = CascadeType.ALL)
    private List<Arbre> arbres;

    public Champ(Long id, double superficie, Ferme ferme) {
        this.id = id;
        this.superficie = superficie;
        this.ferme = ferme;
    }

    public Champ() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public Ferme getFerme() {
        return ferme;
    }

    public void setFerme(Ferme ferme) {
        this.ferme = ferme;
    }

    public List<Arbre> getArbres() {
        return arbres;
    }

    public void setChamps(List<Arbre> arbres) {
        this.arbres = arbres;
    }

}
