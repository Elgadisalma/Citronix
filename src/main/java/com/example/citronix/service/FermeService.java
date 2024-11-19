package com.example.citronix.service;

import com.example.citronix.dto.FermeDto;

import java.util.List;

public interface FermeService {
    FermeDto addFerme(FermeDto fermeDto);

    FermeDto getFermeById(Long id);

    FermeDto updateFerme(FermeDto fermeDto, Long id);

    FermeDto deleteFerme(Long id);

    List<FermeDto> searchFerme(String nom, String localisation, Double minSuperficie, Double maxSuperficie);
}
