package com.example.citronix.service;

import com.example.citronix.dto.RecolteDto;

public interface RecolteService {
    RecolteDto addRecolte(RecolteDto recolteDto);

    RecolteDto findRecolteById(Long id);

    RecolteDto deleteRecolte(Long id);
}
