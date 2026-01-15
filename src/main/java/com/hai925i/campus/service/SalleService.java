package com.hai925i.campus.service;

import com.hai925i.campus.domain.SalleRepository;
import com.hai925i.campus.dto.dto.SalleDTO;
import com.hai925i.campus.dto.mapper.SalleMapper;
import com.hai925i.campus.model.Salle;
import com.hai925i.campus.model.TypeSalle;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SalleService {

    private final SalleRepository salleRepository;
    private final SalleMapper salleMapper;

    public SalleService(SalleRepository salleRepository, SalleMapper salleMapper) {
        this.salleRepository = salleRepository;
        this.salleMapper = salleMapper;
    }

    public List<Salle> findAll(){
        return salleRepository.findAll();
    }

    public List<SalleDTO> getAllSalles() {
        return salleRepository.findAll().stream()
                .map(salleMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<SalleDTO> getSallesByBatiment(String codeBatiment) {
        return salleRepository.findByBatimentCodeB(codeBatiment).stream()
                .map(salleMapper::toDto)
                .collect(Collectors.toList());
    }

    public Map<TypeSalle, Long> countSallesByType() {
        List<Object[]> results = salleRepository.countSallesByTypeS();
        Map<TypeSalle, Long> stats = new HashMap<>();
        for (Object[] result : results) {
            stats.put((TypeSalle) result[0], (Long) result[1]);
        }
        return stats;
    }

    public Map<String, Long> countSallesByBatiment() {
        List<Object[]> results = salleRepository.countSallesByBatiment();
        Map<String, Long> stats = new HashMap<>();
        for (Object[] result : results) {
            stats.put((String) result[0], (Long) result[1]);
        }
        return stats;
    }

    public List<SalleDTO> getSallesByUniversite(String nomUniversite) {
        return salleRepository.findByBatimentCampusUniversiteNom(nomUniversite)
                .stream()
                .map(salleMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<Salle> getSallesEntityByUniversite(String nomUniversite) {
        return salleRepository.findByBatimentCampusUniversiteNom(nomUniversite);
    }

    public List<Salle> searchSalles(String keyword, String etage, String acces, String batiment, String campus, String nomUni, Integer capMin) {
        return salleRepository.searchSalles(keyword, etage, acces, batiment, campus, nomUni, capMin);
    }

    public void saveSalle(SalleDTO salleDTO) {
        Salle salle = salleMapper.toEntity(salleDTO);
        salleRepository.save(salle);
    }

    public void deleteSalle(String numS) {
        salleRepository.deleteById(numS);
    }

    public SalleDTO getSalleById(String id) {
        return salleRepository.findById(id)
                .map(salleMapper::toDto)
                .orElse(null);
    }

    public Map<String, Long> countSallesByType(String nomUniversite) {
        List<Object[]> results = salleRepository.countByTypeForUniversite(nomUniversite);

        Map<String, Long> stats = new HashMap<>();

        for (Object[] result : results) {
            String type = (result[0] != null) ? result[0].toString() : "Inconnu";
            Long count = (Long) result[1];

            stats.put(type, count);
        }
        return stats;
    }

    public Map<String, Long> countSallesByTypeForCampus(String nomCampus) {
        List<Object[]> results = salleRepository.countByTypeForCampus(nomCampus);
        Map<String, Long> stats = new HashMap<>();
        for (Object[] result : results) {
            stats.put(result[0].toString(), (Long) result[1]);
        }
        return stats;
    }

}