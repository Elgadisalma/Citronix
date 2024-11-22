package com.example.citronix.service.impl;

import com.example.citronix.dto.FermeDto;
import com.example.citronix.entity.Ferme;
import com.example.citronix.mapper.FermeMapper;
import com.example.citronix.repository.FermeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FermeServiceImplTest {

    @Mock
    private FermeRepository fermeRepository;

    @Mock
    private FermeMapper fermeMapper;

    @InjectMocks
    private FermeServiceImpl fermeService;

    private Ferme ferme;
    private FermeDto fermeDto;

    @BeforeEach
    public void setUp() {
        fermeDto = new FermeDto(1L, "Ferme A", "Localisation A", 100.0, LocalDate.of(2024, 1, 1));
        ferme = new Ferme(1L, "Ferme A", "Localisation A", 100.0, LocalDate.of(2024, 1, 1));

    }

    @Test
    public void testAddFerme() {
        when(fermeMapper.toEntity(any(FermeDto.class))).thenReturn(ferme);
        when(fermeRepository.save(any(Ferme.class))).thenReturn(ferme);
        when(fermeMapper.toDTO(any(Ferme.class))).thenReturn(fermeDto);

        FermeDto result = fermeService.addFerme(fermeDto);

        verify(fermeRepository, times(1)).save(any(Ferme.class));
        assert(result != null);
        assert(result.getNom().equals("Ferme A"));
    }

    @Test
    public void testGetFermeById() {
        when(fermeRepository.findById(anyLong())).thenReturn(Optional.of(ferme));
        when(fermeMapper.toDTO(any(Ferme.class))).thenReturn(fermeDto);

        FermeDto result = fermeService.getFermeById(1L);

        verify(fermeRepository, times(1)).findById(anyLong());
        assert(result != null);
        assert(result.getNom().equals("Ferme A"));
    }

    @Test
    public void testUpdateFerme() {
        when(fermeRepository.findById(1L)).thenReturn(Optional.of(ferme));
        when(fermeRepository.save(any(Ferme.class))).thenReturn(ferme);
        when(fermeMapper.toDTO(any(Ferme.class))).thenReturn(new FermeDto(1L, "Ferme B", "Localisation B", 200.0, LocalDate.of(2024, 2, 1)));

        FermeDto updatedDto = new FermeDto(1L, "Ferme B", "Localisation B", 200.0, LocalDate.of(2024, 2, 1));
        FermeDto result = fermeService.updateFerme(updatedDto, 1L);

        assert(result != null);
        assert(result.getNom().equals("Ferme B"));
        assert(result.getSuperficie() == 200.0);
    }


    @Test
    public void testDeleteFerme() {
        when(fermeRepository.findById(anyLong())).thenReturn(Optional.of(ferme));
        when(fermeMapper.toDTO(any(Ferme.class))).thenReturn(fermeDto);

        FermeDto result = fermeService.deleteFerme(1L);

        verify(fermeRepository, times(1)).delete(any(Ferme.class));
        assert(result != null);
        assert(result.getNom().equals("Ferme A"));
    }

    @Test
    public void testSearchFerme() {
        List<Ferme> fermesList = List.of(ferme);
        when(fermeRepository.searchFerme(any(), any(), any(), any())).thenReturn(fermesList);
        when(fermeMapper.toDTO(anyList())).thenReturn(List.of(fermeDto));

        List<FermeDto> result = fermeService.searchFerme("Ferme A", "Localisation A", 50.0, 150.0);

        verify(fermeRepository, times(1)).searchFerme(any(), any(), any(), any());
        assert(result != null);
        assert(result.size() == 1);
        assert(result.get(0).getNom().equals("Ferme A"));
    }
}
