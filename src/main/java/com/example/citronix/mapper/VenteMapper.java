package com.example.citronix.mapper;

import com.example.citronix.dto.VenteDto;
import com.example.citronix.entity.Vente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VenteMapper {

    VenteDto toDTO(Vente vente);

    Vente toEntity(VenteDto venteDto);
}
