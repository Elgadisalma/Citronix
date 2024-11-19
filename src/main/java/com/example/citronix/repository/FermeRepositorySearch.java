package com.example.citronix.repository;

import com.example.citronix.entity.Ferme;
import java.util.List;

public interface FermeRepositorySearch {
    List<Ferme> searchFerme(String nom, String localisation, Double minSuperficie, Double maxSuperficie);
}
