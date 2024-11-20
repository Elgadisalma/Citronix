package com.example.citronix.service.impl;

import com.example.citronix.dto.ChampDto;
import com.example.citronix.entity.Champ;
import com.example.citronix.entity.Ferme;
import com.example.citronix.mapper.ChampMapper;
import com.example.citronix.repository.ChampRepository;
import com.example.citronix.repository.FermeRepository;
import com.example.citronix.service.ChampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ChampServiceImpl implements ChampService {

    @Autowired
    private ChampRepository champRepository;

    @Autowired
    private ChampMapper champMapper;

    @Autowired
    private FermeRepository fermeRepository;

    @Override
    public ChampDto addChamp(ChampDto champDto) {
        Ferme ferme = fermeRepository.findById(champDto.getIdFerme()).orElse(null);
        if (ferme == null) {
            throw new IllegalArgumentException("Ferme non trouvée avec l'ID : " + champDto.getIdFerme());
        }

        if (champDto.getSuperficie() < 0.1) {
            throw new IllegalArgumentException("La superficie du champ doit être d'au moins 0.1 hectare.");
        }

        double superficieTotaleActuelle = champRepository.findByFermeId(ferme.getId())
                .stream()
                .mapToDouble(Champ::getSuperficie)
                .sum();

        if (superficieTotaleActuelle + champDto.getSuperficie() > ferme.getSuperficie()) {
            throw new IllegalArgumentException("La superficie totale des champs dépasse la superficie de la ferme.");
        }

        if (champDto.getSuperficie() > ferme.getSuperficie() * 0.5) {
            throw new IllegalArgumentException("La superficie totale de ce champs dépasse 50% de la superficie de la ferme.");
        }

        if (ferme.getChamps().size() >= 10) {
            throw new IllegalArgumentException("La ferme ne peut pas contenir plus de 10 champs.");
        }

        Champ champ = champMapper.toEntity(champDto);
        champ.setFerme(ferme);
        ferme.getChamps().add(champ);

        champRepository.save(champ);
        fermeRepository.save(ferme);

        return champMapper.toDTO(champ);
    }

    @Override
    public ChampDto updateChamp(ChampDto champDto, Long id) {
        Champ existingChamp = champRepository.findById(id).orElse(null);
        if (existingChamp == null) {
            return null;
        }

        Ferme ferme = fermeRepository.findById(champDto.getIdFerme()).orElse(null);
        if (ferme == null) {
            throw new IllegalArgumentException("Ferme non trouvée avec l'ID : " + champDto.getIdFerme());
        }

        if (champDto.getSuperficie() > ferme.getSuperficie()) {
            throw new IllegalArgumentException("La superficie du champ ne peut pas dépasser celle de la ferme.");
        }

        existingChamp.setSuperficie(champDto.getSuperficie());

        Champ updatedChamp = champRepository.save(existingChamp);

        return champMapper.toDTO(updatedChamp);
    }

    @Override
    public ChampDto getChampById(Long id) {
        Champ champ = champRepository.findById(id).orElse(null);
        return champMapper.toDTO(champ);
    }

    @Override
    public ChampDto deleteChamp(Long id) {
        Champ existingChamp = champRepository.findById(id).orElse(null);
        if (existingChamp == null) {
            return null;
        }

        champRepository.delete(existingChamp);

        return champMapper.toDTO(existingChamp);
    }
}
