package com.example.citronix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
