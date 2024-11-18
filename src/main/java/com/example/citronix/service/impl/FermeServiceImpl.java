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
}
