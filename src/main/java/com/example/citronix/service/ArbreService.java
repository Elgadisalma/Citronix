package com.example.citronix.service;

import com.example.citronix.dto.ArbreDto;

import java.util.List;

public interface ArbreService {
    ArbreDto addArbre(ArbreDto arbreDto);
    ArbreDto updateArbre(ArbreDto arbreDto, Long id);
    ArbreDto getArbreById(Long id);
    ArbreDto deleteArbre(Long id);
    List<ArbreDto> getAllArbres();
}
