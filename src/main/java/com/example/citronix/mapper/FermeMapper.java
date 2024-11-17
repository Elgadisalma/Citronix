package com.example.citronix.mapper;

import com.example.citronix.dto.FermeDto;
import com.example.citronix.entity.Ferme;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FermeMapper {
    FermeDto toDTO(Ferme ferme);
    Ferme toEntity(FermeDto fermeDto);
}
