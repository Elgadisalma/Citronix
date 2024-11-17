package com.example.citronix.mapper;

import com.example.citronix.dto.ArbreDto;
import com.example.citronix.entity.Arbre;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArbreMapper {
    ArbreDto toDTO(Arbre arbre);
    Arbre toEntity(ArbreDto dto);
}

