package com.example.citronix.controller;

import com.example.citronix.dto.VenteDto;
import com.example.citronix.dto.UpdateVenteDto;
import com.example.citronix.service.VenteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<VenteDto> deleteVente(@PathVariable Long id){
        VenteDto deletedVente = venteService.deleteVente(id);
        if (deletedVente != null) {
            return ResponseEntity.ok(deletedVente);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<VenteDto> getVenteById(@PathVariable Long id) {
        VenteDto venteDto = venteService.getVenteById(id);
        if (venteDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(venteDto);
    }

}
