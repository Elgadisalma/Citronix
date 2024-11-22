package com.example.citronix.service.impl;

import com.example.citronix.dto.RecolteDto;
import com.example.citronix.entity.*;
import com.example.citronix.mapper.RecolteMapper;
import com.example.citronix.repository.ArbreRepository;
import com.example.citronix.repository.DetailRecolteRepository;
import com.example.citronix.repository.RecolteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecolteServiceImplTest {

    @Mock
    private RecolteRepository recolteRepository;

    @Mock
    private DetailRecolteRepository detailRecolteRepository;

    @Mock
    private ArbreRepository arbreRepository;

    @Mock
    private RecolteMapper recolteMapper;

    @InjectMocks
    private RecolteServiceImpl recolteService;

    @Test
    void testAddRecolte_Success() {
        RecolteDto recolteDto = new RecolteDto();
        recolteDto.setSaison("été");
        recolteDto.setDateRecolte(LocalDate.of(2024, 7, 15));
        recolteDto.setChampId(1L);

        Arbre arbre = new Arbre();
        arbre.setId(1L);
        arbre.setDatePlantation(LocalDate.of(2018, 1, 1));
        arbre.setChamp(new Champ());

        List<Arbre> arbres = List.of(arbre);

        Recolte recolte = new Recolte();
        recolte.setSaison(Saison.été);
        recolte.setDateRecolte(LocalDate.of(2024, 7, 15));
        recolte.setQuantite(12.0);

        when(arbreRepository.findByChampId(1L)).thenReturn(arbres);
        when(recolteRepository.existsBySaisonAndDateRecolteBetween(any(), any(), any())).thenReturn(false);
        when(recolteMapper.toEntity(recolteDto)).thenReturn(recolte);
        when(recolteRepository.save(recolte)).thenReturn(recolte);
        when(recolteMapper.toDTO(recolte)).thenReturn(recolteDto);

        RecolteDto result = recolteService.addRecolte(recolteDto);

        assertNotNull(result);
        verify(arbreRepository, times(1)).findByChampId(1L);
        verify(recolteRepository, times(1)).save(recolte);
        verify(detailRecolteRepository, times(1)).saveAll(anyList());
    }

    @Test
    void testFindRecolteById_Success() {
        Recolte recolte = new Recolte();
        recolte.setSaison(Saison.été);

        RecolteDto recolteDto = new RecolteDto();
        recolteDto.setSaison("été");

        when(recolteRepository.findById(1L)).thenReturn(Optional.of(recolte));
        when(recolteMapper.toDTO(recolte)).thenReturn(recolteDto);

        RecolteDto result = recolteService.findRecolteById(1L);

        assertNotNull(result);
        assertEquals("été", result.getSaison());
    }

    @Test
    void testFindRecolteById_NotFound() {
        when(recolteRepository.findById(1L)).thenReturn(Optional.empty());

        RecolteDto result = recolteService.findRecolteById(1L);

        assertNull(result);
    }

    @Test
    void testDeleteRecolte_Success() {
        Recolte recolte = new Recolte();

        when(recolteRepository.findById(1L)).thenReturn(Optional.of(recolte));

        RecolteDto recolteDto = new RecolteDto();
        when(recolteMapper.toDTO(recolte)).thenReturn(recolteDto);

        RecolteDto result = recolteService.deleteRecolte(1L);

        assertNotNull(result);
        verify(recolteRepository, times(1)).delete(recolte);
    }

    @Test
    void testDeleteRecolte_NotFound() {
        when(recolteRepository.findById(1L)).thenReturn(Optional.empty());

        RecolteDto result = recolteService.deleteRecolte(1L);

        assertNull(result);
        verify(recolteRepository, never()).delete(any());
    }
}
