package com.example.citronix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.citronix.dto.ArbreDto;
import com.example.citronix.service.ArbreService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/arbre")
public class ArbreController {

    @Autowired
    ArbreService arbreService;

    @PostMapping("/add")
    public ResponseEntity<ArbreDto> addArbre(@Valid @RequestBody ArbreDto arbreDto) {
        ArbreDto createdArbre = arbreService.addArbre(arbreDto);
        return ResponseEntity.ok(createdArbre);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArbreDto> getArbreById(@PathVariable Long id) {
        ArbreDto arbreDto = arbreService.getArbreById(id);
        if (arbreDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(arbreDto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ArbreDto> updateArbre(@Valid @RequestBody ArbreDto arbreDto, @PathVariable Long id) {
        ArbreDto updatedArbre = arbreService.updateArbre(arbreDto, id);
        if (updatedArbre != null) {
            return ResponseEntity.ok(updatedArbre);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ArbreDto> deleteArbre(@PathVariable Long id){
        ArbreDto deletedArbre = arbreService.deleteArbre(id);
        if (deletedArbre != null) {
            return ResponseEntity.ok(deletedArbre);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
