package com.example.citronix.service;

import com.example.citronix.dto.FermeDto;

public interface FermeService {
    FermeDto addFerme(FermeDto fermeDto);

    FermeDto getFermeById(Long id);

    FermeDto updateFerme(FermeDto fermeDto, Long id);

    FermeDto deleteFerme(Long id);
}
