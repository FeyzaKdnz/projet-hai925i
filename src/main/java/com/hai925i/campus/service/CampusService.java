package com.hai925i.campus.service;

import com.hai925i.campus.domain.CampusRepository;
import com.hai925i.campus.dto.dto.CampusDTO;
import com.hai925i.campus.dto.mapper.CampusMapper;
import com.hai925i.campus.model.Campus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hai925i.campus.dto.dto.CampusMapDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampusService {

    private final CampusRepository campusRepository;
    private final CampusMapper campusMapper;

    @Autowired // Injection automatique des dépendances
    public CampusService(CampusRepository campusRepository, CampusMapper campusMapper) {
        this.campusRepository = campusRepository;
        this.campusMapper = campusMapper;
    }

    // 1. Récupérer tous les campus (sous forme de DTO)
    public List<CampusDTO> getAllCampus() {
        List<Campus> campusList = campusRepository.findAll();
        return campusList.stream()
                .map(campusMapper::toDto)
                .collect(Collectors.toList());
    }

    // 2. Récupérer un campus par son nom
    public CampusDTO getCampus(String nomC) {
        Campus campus = campusRepository.findByNomC(nomC);
        return campusMapper.toDto(campus);
    }

    // 3. Créer un nouveau campus
    public void createCampus(CampusDTO dto) {
        Campus campus = campusMapper.toEntity(dto);
        campusRepository.save(campus);
    }

    public long getNbCampusByUniversite(String nomUniversite) {
        return campusRepository.countByUniversiteNom(nomUniversite);
    }

    public List<Campus> getCampusesByUniversite(String nomUniversite) {
        return campusRepository.findByUniversiteNom(nomUniversite);
    }

    public List<CampusMapDTO> getCampusDTOsByUniversite(String nomUniversite) {
        return campusRepository.findByUniversiteNom(nomUniversite) // Votre méthode existante qui retourne List<Campus>
                .stream()
                .map(campus -> new CampusMapDTO(
                        campus.getNomC(),
                        campus.getLatitude(),
                        campus.getLongitude(),
                        campus.getVille()))
                .collect(Collectors.toList());
    }
}