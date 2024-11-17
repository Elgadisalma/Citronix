package com.example.citronix.mapper;

import com.example.citronix.dto.RecolteDto;
import com.example.citronix.entity.Recolte;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecolteMapper {
    RecolteDto toDTO(Recolte recolte);
    Recolte toEntity(RecolteDto recolteDto);
}
