package com.example.citronix.mapper;

import com.example.citronix.dto.DetailRecolteDto;
import com.example.citronix.entity.DetailRecolte;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DetailRecolteMapper {
    DetailRecolteDto toDTO(DetailRecolte detailRecolte);
    DetailRecolte toEntity(DetailRecolteDto detailRecolteDto);
}
