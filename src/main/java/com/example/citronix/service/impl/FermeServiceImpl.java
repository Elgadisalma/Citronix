package com.example.citronix.service.impl;

import com.example.citronix.dto.FermeDto;
import com.example.citronix.entity.Ferme;
import com.example.citronix.mapper.FermeMapper;
import com.example.citronix.repository.FermeRepository;
import com.example.citronix.service.FermeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FermeServiceImpl implements FermeService {

    @Autowired
    private FermeRepository fermeRepository;

    @Autowired
    private FermeMapper fermeMapper;

    public FermeDto addFerme(FermeDto fermeDto) {
        Ferme ferme = fermeMapper.toEntity(fermeDto);
        Ferme savedFerme = fermeRepository.save(ferme);
        return fermeMapper.toDTO(savedFerme);
    }

    @Override
    public FermeDto getFermeById(Long id) {
        Ferme ferme = fermeRepository.findById(id).orElse(null);
        return fermeMapper.toDTO(ferme);
    }

    @Override
    public FermeDto updateFerme(FermeDto fermeDto, Long id) {
        Ferme existingFerme = fermeRepository.findById(id).orElse(null);
        if (existingFerme == null) {
            return null;
        }

        existingFerme.setNom(fermeDto.getNom());
        existingFerme.setLocalisation(fermeDto.getLocalisation());
        existingFerme.setSuperficie(fermeDto.getSuperficie());
        existingFerme.setDateCreation(fermeDto.getDateCreation());

        Ferme updatedFerme = fermeRepository.save(existingFerme);

        return fermeMapper.toDTO(updatedFerme);
    }

}
