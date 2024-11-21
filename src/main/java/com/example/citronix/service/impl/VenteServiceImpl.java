package com.example.citronix.service.impl;

import com.example.citronix.dto.UpdateVenteDto;
import com.example.citronix.dto.VenteDto;
import com.example.citronix.entity.Recolte;
import com.example.citronix.entity.Vente;
import com.example.citronix.mapper.VenteMapper;
import com.example.citronix.repository.RecolteRepository;
import com.example.citronix.repository.VenteRepository;
import com.example.citronix.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenteServiceImpl implements VenteService {

    @Autowired
    VenteRepository venteRepository;

    @Autowired
    RecolteRepository recolteRepository;

    @Autowired
    VenteMapper venteMapper;

    @Override
    public VenteDto addVente(VenteDto venteDto) {
        Recolte recolte = recolteRepository.findById(venteDto.getIdRecolte())
                .orElseThrow(() -> new IllegalArgumentException("Récolte introuvable pour l'ID fourni : " + venteDto.getIdRecolte()));

        if (venteDto.getDateVente().isBefore(recolte.getDateRecolte())) {
            throw new IllegalArgumentException("La date de vente doit être postérieure à la date de récolte.");
        }

        boolean venteExistante = venteRepository.existsByRecolte(recolte);
        if (venteExistante) {
            throw new IllegalArgumentException("Cette récolte a déjà été vendue pour la saison : " + recolte.getSaison());
        }

        Vente vente = new Vente();
        vente.setDateVente(venteDto.getDateVente());
        vente.setClient(venteDto.getClient());
        vente.setQuantite(recolte.getQuantite());
        vente.setPrixUnitaire(venteDto.getPrixUnitaire());
        vente.setRecolte(recolte);

        Vente savedVente = venteRepository.save(vente);

        return venteMapper.toDTO(savedVente);
    }


    @Override
    public VenteDto updateVente(Long id, UpdateVenteDto updateVenteDto) {
        Vente existingVente = venteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vente introuvable pour l'ID fourni : " + id));

        if (updateVenteDto.getDateVente().isBefore(existingVente.getRecolte().getDateRecolte())) {
            throw new IllegalArgumentException("La date de vente doit être postérieure à la date de récolte.");
        }

        existingVente.setClient(updateVenteDto.getClient());
        existingVente.setPrixUnitaire(updateVenteDto.getPrixUnitaire());
        existingVente.setDateVente(updateVenteDto.getDateVente());

        Vente updatedVente = venteRepository.save(existingVente);

        return venteMapper.toDTO(updatedVente);
    }


}
