package com.example.citronix.repository;

import com.example.citronix.entity.Arbre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArbreRepository extends JpaRepository<Arbre, Long>  {
}
