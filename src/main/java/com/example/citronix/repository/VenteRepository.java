package com.example.citronix.repository;

import com.example.citronix.entity.Recolte;
import com.example.citronix.entity.Saison;
import com.example.citronix.entity.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenteRepository extends JpaRepository<Vente, Long> {
    boolean existsByRecolte(Recolte recolte);
}
