package com.example.citronix.controller;

import com.example.citronix.entity.Ferme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.citronix.dto.FermeDto;
import com.example.citronix.service.FermeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ferme")
public class FermeController {

    @Autowired
    FermeService fermeService;

    @PostMapping("/add")
    public ResponseEntity<FermeDto> addFerme(@Valid @RequestBody FermeDto fermeDto) {
        FermeDto createdFerme = fermeService.addFerme(fermeDto);
        return ResponseEntity.ok(createdFerme);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FermeDto> findFermeById(@PathVariable Long id) {
        FermeDto fermeDto = fermeService.getFermeById(id);
        if (fermeDto != null) {
            return ResponseEntity.ok(fermeDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FermeDto> updateFerme(@Valid @RequestBody FermeDto fermeDto, @PathVariable Long id) {
        FermeDto updatedFerme = fermeService.updateFerme(fermeDto, id);
        if (updatedFerme != null) {
            return ResponseEntity.ok(updatedFerme);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
