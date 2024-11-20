package com.example.citronix.controller;

import com.example.citronix.dto.RecolteDto;
import com.example.citronix.service.RecolteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recolte")
public class RecolteController {

    @Autowired
    RecolteService recolteService;

    @PostMapping("/add")
    public ResponseEntity<RecolteDto> addRecolte(@RequestBody RecolteDto recolteDto){
        RecolteDto createdRecolte = recolteService.addRecolte(recolteDto);
        return ResponseEntity.ok(createdRecolte);
    }
}
