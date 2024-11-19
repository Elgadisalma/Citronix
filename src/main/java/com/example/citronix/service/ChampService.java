package com.example.citronix.service;

import com.example.citronix.dto.ChampDto;

public interface ChampService {
    ChampDto addChamp(ChampDto champDto);


    ChampDto updateChamp(ChampDto champDto, Long id);

    ChampDto getChampById(Long id);
}
