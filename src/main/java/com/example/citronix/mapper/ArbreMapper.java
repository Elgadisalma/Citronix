package com.example.citronix.mapper;

import com.example.citronix.dto.ArbreDto;
import com.example.citronix.dto.FermeDto;
import com.example.citronix.entity.Arbre;
import com.example.citronix.entity.Ferme;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArbreMapper {
    ArbreDto toDTO(Arbre arbre);

    Arbre toEntity(ArbreDto dto);

    List<ArbreDto> toDTO(List<Arbre> arbres);

}