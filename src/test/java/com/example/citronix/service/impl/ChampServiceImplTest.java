package com.example.citronix.service.impl;

import com.example.citronix.dto.ChampDto;
import com.example.citronix.entity.Champ;
import com.example.citronix.entity.Ferme;
import com.example.citronix.mapper.ChampMapper;
import com.example.citronix.repository.ChampRepository;
import com.example.citronix.repository.FermeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ChampServiceImplTest {

    @Mock
    private ChampRepository champRepository;

    @Mock
    private FermeRepository fermeRepository;

    @Mock
    private ChampMapper champMapper;

    @InjectMocks
    private ChampServiceImpl champService;

    private Champ champ;
    private ChampDto champDto;
    private Ferme ferme;

    @BeforeEach
    public void setUp() {
        ferme = new Ferme(1L, "Ferme A", "Localisation A", 100.0, LocalDate.now());
        champ = new Champ(1L, 10.0, ferme);
        champDto = new ChampDto(1L, 10.0, 1L, null);
    }

    @Test
    public void testAddChamp() {
        when(fermeRepository.findById(anyLong())).thenReturn(Optional.of(ferme));
        when(champRepository.findByFermeId(anyLong())).thenReturn(List.of(champ));
        when(champMapper.toEntity(any(ChampDto.class))).thenReturn(champ);
        when(champRepository.save(any(Champ.class))).thenReturn(champ);
        when(champMapper.toDTO(any(Champ.class))).thenReturn(champDto);

        ChampDto result = champService.addChamp(champDto);

        verify(champRepository, times(1)).save(any(Champ.class));
        verify(fermeRepository, times(1)).save(any(Ferme.class));
        assert(result != null);
        assert(result.getSuperficie() == 10.0);
    }

    @Test
    public void testGetChampById() {
        when(champRepository.findById(anyLong())).thenReturn(Optional.of(champ));
        when(champMapper.toDTO(any(Champ.class))).thenReturn(champDto);

        ChampDto result = champService.getChampById(1L);

        verify(champRepository, times(1)).findById(anyLong());
        assert(result != null);
        assert(result.getId() == 1L);
    }

    @Test
    public void testUpdateChamp() {
        when(champRepository.findById(anyLong())).thenReturn(Optional.of(champ));
        when(fermeRepository.findById(anyLong())).thenReturn(Optional.of(ferme));
        when(champRepository.save(any(Champ.class))).thenReturn(champ);
        when(champMapper.toDTO(any(Champ.class))).thenReturn(new ChampDto(1L, 20.0, 1L, null));

        ChampDto updatedDto = new ChampDto(1L, 20.0, 1L, null);
        ChampDto result = champService.updateChamp(updatedDto, 1L);

        verify(champRepository, times(1)).save(any(Champ.class));
        assert(result != null);
        assert(result.getSuperficie() == 20.0);
    }

    @Test
    public void testDeleteChamp() {
        when(champRepository.findById(anyLong())).thenReturn(Optional.of(champ));
        when(champMapper.toDTO(any(Champ.class))).thenReturn(champDto);

        ChampDto result = champService.deleteChamp(1L);

        verify(champRepository, times(1)).delete(any(Champ.class));
        assert(result != null);
        assert(result.getId() == 1L);
    }
}
