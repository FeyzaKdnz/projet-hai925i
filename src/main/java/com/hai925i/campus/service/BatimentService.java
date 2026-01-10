package com.hai925i.campus.service;

import com.hai925i.campus.domain.BatimentRepository;
import com.hai925i.campus.dto.dto.BatimentDTO;
import com.hai925i.campus.dto.mapper.BatimentMapper;
import com.hai925i.campus.model.Batiment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatimentService {

    private final BatimentRepository batimentRepository;
    private final BatimentMapper batimentMapper;

    public BatimentService(BatimentRepository batimentRepository, BatimentMapper batimentMapper) {
        this.batimentRepository = batimentRepository;
        this.batimentMapper = batimentMapper;
    }

    public List<Batiment> findAll(){
        return batimentRepository.findAll();
    }

    public List<BatimentDTO> getAllBatiments() {
        return batimentRepository.findAll().stream()
                .map(batimentMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<BatimentDTO> getBatimentsByCampus(String nomCampus) {
        return batimentRepository.findByCampusNomC(nomCampus).stream()
                .map(batimentMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<BatimentDTO> getBatimentByUniversite(String nomUniversite) {
        List<Batiment> batiments = batimentRepository.findByCampusUniversiteNom(nomUniversite);
        return batiments.stream()
                .map(batimentMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<Batiment> findByUniversite(String nomUniversite) {
        return batimentRepository.findByCampusUniversiteNom(nomUniversite);
    }
}