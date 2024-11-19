package com.example.citronix.service.impl;

import com.example.citronix.dto.ChampDto;
import com.example.citronix.entity.Champ;
import com.example.citronix.mapper.ChampMapper;
import com.example.citronix.repository.ChampRepository;
import com.example.citronix.service.ChampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChampServiceImpl implements ChampService {

    @Autowired
    private ChampRepository champRepository;

    @Autowired
    private ChampMapper champMapper;

    public ChampDto addChamp(ChampDto champDto) {
        Champ champ = champMapper.toEntity(champDto);
        Champ savedChamp = champRepository.save(champ);
        return champMapper.toDTO(savedChamp);
    }


}
