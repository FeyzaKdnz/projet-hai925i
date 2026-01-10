package com.hai925i.campus.controller;

import com.hai925i.campus.dto.dto.CampusDTO;
import com.hai925i.campus.service.CampusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campus")
public class CampusDTORestController {

    private final CampusService campusService;

    // Injection du service via le constructeur
    public CampusDTORestController(CampusService campusService) {
        this.campusService = campusService;
    }

    // 1. GET http://localhost:8080/api/campus
    @GetMapping
    public List<CampusDTO> getAllCampus() {
        return campusService.getAllCampus();
    }

    // 2. GET http://localhost:8080/api/campus/Triolet
    @GetMapping("/{nom}")
    public CampusDTO getCampus(@PathVariable String nom) {
        return campusService.getCampus(nom);
    }

    // 3. POST http://localhost:8080/api/campus
    @PostMapping
    public void createCampus(@RequestBody CampusDTO campusDTO) {
        campusService.createCampus(campusDTO);
    }
}