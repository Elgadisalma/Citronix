package com.example.citronix.service.impl;

import com.example.citronix.dto.ArbreDto;
import com.example.citronix.entity.Arbre;
import com.example.citronix.entity.Champ;
import com.example.citronix.mapper.ArbreMapper;
import com.example.citronix.repository.ArbreRepository;
import com.example.citronix.repository.ChampRepository;
import com.example.citronix.service.ArbreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArbreServiceImpl implements ArbreService {

    @Autowired
    private ArbreRepository arbreRepository;

    @Autowired
    private ChampRepository champRepository;

    @Autowired
    private ArbreMapper arbreMapper;

    @Override
    public ArbreDto addArbre(ArbreDto arbreDto) {
        Champ champ = champRepository.findById(arbreDto.getIdChamp()).orElseThrow(
                () -> new IllegalArgumentException("Champ non trouvé avec l'ID : " + arbreDto.getIdChamp())
        );

        Arbre arbre = arbreMapper.toEntity(arbreDto);
        arbre.setChamp(champ);

        Arbre savedArbre = arbreRepository.save(arbre);
        return arbreMapper.toDTO(savedArbre);
    }

    @Override
    public ArbreDto updateArbre(ArbreDto arbreDto, Long id) {
        Arbre existingArbre = arbreRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Arbre non trouvé avec l'ID : " + id)
        );

        existingArbre.setType(arbreDto.getType());
        existingArbre.setDatePlantation(arbreDto.getDatePlantation());

        Arbre updatedArbre = arbreRepository.save(existingArbre);
        return arbreMapper.toDTO(updatedArbre);
    }

    @Override
    public ArbreDto getArbreById(Long id) {
        Arbre arbre = arbreRepository.findById(id).orElse(null);
        if (arbre == null) {
            return null;
        }
        return arbreMapper.toDTO(arbre);
    }

    @Override
    public ArbreDto deleteArbre(Long id) {
        Arbre existingArbre = arbreRepository.findById(id).orElse(null);
        if (existingArbre == null) {
            return null;
        }

        arbreRepository.delete(existingArbre);

        return arbreMapper.toDTO(existingArbre);
    }

    @Override
    public List<ArbreDto> getArbresByChampId(Long champId) {
        List<Arbre> arbreDeChamp = arbreRepository.findByChampId(champId);
        return arbreMapper.toDTO(arbreDeChamp);
    }
}
