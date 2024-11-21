package com.example.citronix.service.impl;

import com.example.citronix.dto.RecolteDto;
import com.example.citronix.entity.Arbre;
import com.example.citronix.entity.DetailRecolte;
import com.example.citronix.entity.Recolte;
import com.example.citronix.entity.Saison;
import com.example.citronix.mapper.RecolteMapper;
import com.example.citronix.repository.ArbreRepository;
import com.example.citronix.repository.DetailRecolteRepository;
import com.example.citronix.repository.RecolteRepository;
import com.example.citronix.service.RecolteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecolteServiceImpl implements RecolteService {

    @Autowired
    RecolteMapper recolteMapper;

    @Autowired
    RecolteRepository recolteRepository;

    @Autowired
    DetailRecolteRepository detailRecolteRepository;

    @Autowired
    ArbreRepository arbreRepository;

    @Override
    public RecolteDto addRecolte(RecolteDto recolteDto) {
        validateRecolte(recolteDto);

        Recolte recolte = recolteMapper.toEntity(recolteDto);

        Long champId = recolteDto.getChampId();
        List<DetailRecolte> detailRecoltes = generateDetailRecoltes(recolte, champId);

        double totalQuantity = detailRecoltes.stream()
                .mapToDouble(DetailRecolte::getQuantite)
                .sum();
        recolte.setQuantite(totalQuantity);

        recolte = recolteRepository.save(recolte);

        detailRecolteRepository.saveAll(detailRecoltes);

        return recolteMapper.toDTO(recolte);
    }

    private void validateRecolte(RecolteDto recolteDto) {
        Saison saisonEnum;
        try {
            saisonEnum = Saison.valueOf(recolteDto.getSaison().toLowerCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Saison invalide : " + recolteDto.getSaison());
        }

        boolean exists = recolteRepository.existsBySaisonAndDateRecolteBetween(
                saisonEnum,
                recolteDto.getDateRecolte().minusMonths(3),
                recolteDto.getDateRecolte()
        );

        if (exists) {
            throw new IllegalArgumentException("Une récolte pour cette saison existe déjà.");
        }

        if (!isDateInSaison(saisonEnum, recolteDto.getDateRecolte())) {
            throw new IllegalArgumentException("La date de la récolte ne correspond pas à la saison spécifiée.");
        }
    }

    private boolean isDateInSaison(Saison saison, LocalDate date) {
        int month = date.getMonthValue();
        switch (saison) {
            case printemps:
                return month >= 3 && month <= 5;
            case été:
                return month >= 6 && month <= 8;
            case automne:
                return month >= 9 && month <= 11;
            case hiver:
                return month == 12 || month <= 2;
            default:
                return false;
        }
    }

    private List<DetailRecolte> generateDetailRecoltes(Recolte recolte, Long champId) {
        List<Arbre> arbres = arbreRepository.findByChampId(champId);

        List<DetailRecolte> detailRecoltes = new ArrayList<>();
        for (Arbre arbre : arbres) {
            DetailRecolte detailRecolte = new DetailRecolte();
            detailRecolte.setRecolte(recolte);
            detailRecolte.setArbre(arbre);
            detailRecolte.setQuantite(arbre.getProductiviteAnnuelle());

            detailRecoltes.add(detailRecolte);
        }

        return detailRecoltes;
    }

    @Override
    public RecolteDto findRecolteById(Long id){
        Recolte recolte = recolteRepository.findById(id).orElse(null);
        if (recolte == null) {
            return null;
        }
        return recolteMapper.toDTO(recolte);
    }
}
