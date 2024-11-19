package com.example.citronix.service.impl;

import com.example.citronix.dto.ChampDto;
import com.example.citronix.entity.Champ;
import com.example.citronix.mapper.ChampMapper;
import com.example.citronix.repository.ChampRepository;
import com.example.citronix.service.ChampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    @Override
    public ChampDto updateChamp(ChampDto champDto, Long id) {
        Champ existingChamp = champRepository.findById(id).orElse(null);
        if (existingChamp == null) {
            return null;
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




}
