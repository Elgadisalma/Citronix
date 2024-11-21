package com.example.citronix.repository;

import com.example.citronix.entity.Recolte;
import com.example.citronix.entity.Saison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface RecolteRepository extends JpaRepository<Recolte, Long> {
    boolean existsBySaisonAndDateRecolteBetween(Saison saison, LocalDate startDate, LocalDate endDate);
}
