package com.example.citronix.controller;

import com.example.citronix.dto.VenteDto;
import com.example.citronix.service.VenteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
