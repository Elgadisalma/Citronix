package com.example.citronix.controller;

import com.example.citronix.entity.Champ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.citronix.dto.ChampDto;
import com.example.citronix.service.ChampService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/champ")
public class ChampController {

    @Autowired
    ChampService champService;

    @PostMapping("/add")
    public ResponseEntity<ChampDto> addChamp(@Valid @RequestBody ChampDto champDto) {
        ChampDto createdChamp = champService.addChamp(champDto);
        return ResponseEntity.ok(createdChamp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChampDto> findChampById(@PathVariable Long id) {
        ChampDto champDto = champService.getChampById(id);
        if (champDto != null) {
            return ResponseEntity.ok(champDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChampDto> updateChamp(@Valid @RequestBody ChampDto champDto, @PathVariable Long id) {
        ChampDto updatedChamp = champService.updateChamp(champDto, id);
        if (updatedChamp != null) {
            return ResponseEntity.ok(updatedChamp);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ChampDto> deleteChamp(@PathVariable Long id){
        ChampDto deletedChamp = champService.deleteChamp(id);
        if (deletedChamp != null) {
            return ResponseEntity.ok(deletedChamp);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}
