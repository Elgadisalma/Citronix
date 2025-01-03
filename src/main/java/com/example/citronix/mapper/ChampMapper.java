package com.example.citronix.mapper;

import com.example.citronix.dto.ChampDto;
import com.example.citronix.entity.Champ;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChampMapper {

    ChampDto toDTO(Champ champ);

    Champ toEntity(ChampDto champDTO);
}
