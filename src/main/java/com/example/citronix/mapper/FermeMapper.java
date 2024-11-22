package com.example.citronix.mapper;

import com.example.citronix.dto.FermeDto;
import com.example.citronix.entity.Ferme;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FermeMapper {

    FermeDto toDTO(Ferme ferme);

    Ferme toEntity(FermeDto fermeDto);

    List<FermeDto> toDTO(List<Ferme> fermes);
}
