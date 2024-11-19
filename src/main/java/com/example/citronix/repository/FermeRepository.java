package com.example.citronix.repository;

import com.example.citronix.entity.Ferme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FermeRepository extends JpaRepository<Ferme, Long> , FermeRepositorySearch{
}
