package com.example.citronix.service;

import com.example.citronix.dto.UpdateVenteDto;
import com.example.citronix.dto.VenteDto;

public interface VenteService {
    VenteDto addVente(VenteDto venteDto);

    VenteDto updateVente(Long id, UpdateVenteDto updateVenteDto);

    VenteDto deleteVente(Long id);

    VenteDto getVenteById(Long id);
}
