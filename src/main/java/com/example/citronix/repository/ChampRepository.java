package com.example.citronix.repository;

import com.example.citronix.entity.Champ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface ChampRepository extends JpaRepository<Champ, Long> {
    List<Champ> findByFermeId(Long fermeId);
}
