package com.example.citronix.repository;

import com.example.citronix.entity.DetailRecolte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRecolteRepository extends JpaRepository<DetailRecolte, Long> {
}
