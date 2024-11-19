package com.example.citronix.repository.impl;

import com.example.citronix.entity.Ferme;
import com.example.citronix.repository.FermeRepositorySearch;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

public class FermeRepositorySearchImpl implements FermeRepositorySearch {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Ferme> searchFerme(String nom, String localisation, Double minSuperficie, Double maxSuperficie) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ferme> query = cb.createQuery(Ferme.class);
        Root<Ferme> ferme = query.from(Ferme.class);

        List<Predicate> predicates = new ArrayList<>();

        if (nom != null && !nom.isEmpty()) {
            predicates.add(cb.like(cb.lower(ferme.get("nom")), "%" + nom.toLowerCase() + "%"));
        }

        if (localisation != null && !localisation.isEmpty()) {
            predicates.add(cb.like(cb.lower(ferme.get("localisation")), "%" + localisation.toLowerCase() + "%"));
        }

        if (minSuperficie != null) {
            predicates.add(cb.greaterThanOrEqualTo(ferme.get("superficie"), minSuperficie));
        }

        if (maxSuperficie != null) {
            predicates.add(cb.lessThanOrEqualTo(ferme.get("superficie"), maxSuperficie));
        }

        query.where(cb.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(query).getResultList();
    }
}
