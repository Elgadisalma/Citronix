package com.example.citronix.controller;

import com.example.citronix.dto.UpdateVenteDto;
import com.example.citronix.dto.VenteDto;
import com.example.citronix.service.VenteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vente")
public class VenteController {

    @Autowired
    VenteService venteService;

    @PostMapping("/add")
    public ResponseEntity<VenteDto> addVente(@Valid @RequestBody VenteDto venteDto) {
        VenteDto createdVente = venteService.addVente(venteDto);
        return ResponseEntity.ok(createdVente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VenteDto> updateVente(
            @PathVariable Long id,
            @Validated @RequestBody UpdateVenteDto updateVenteDto) {
        VenteDto updatedVente = venteService.updateVente(id, updateVenteDto);
        return ResponseEntity.ok(updatedVente);
    }
}
