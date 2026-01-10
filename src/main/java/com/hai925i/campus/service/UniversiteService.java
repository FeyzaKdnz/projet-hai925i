package com.hai925i.campus.service;

import com.hai925i.campus.domain.UniversiteRepository;
import com.hai925i.campus.model.Universite;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UniversiteService {
    private final UniversiteRepository universiteRepository;

    public UniversiteService(UniversiteRepository universiteRepository) {
        this.universiteRepository = universiteRepository;
    }

    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }
}