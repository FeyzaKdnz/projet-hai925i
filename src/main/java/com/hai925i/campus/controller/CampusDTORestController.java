package com.hai925i.campus.controller;

import com.hai925i.campus.dto.dto.CampusDTO;
import com.hai925i.campus.service.CampusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campus")
public class CampusDTORestController {

    private final CampusService campusService;
    public CampusDTORestController(CampusService campusService) {
        this.campusService = campusService;
    }

    @GetMapping
    public List<CampusDTO> getAllCampus() {
        return campusService.getAllCampus();
    }

    @GetMapping("/{nom}")
    public CampusDTO getCampus(@PathVariable String nom) {
        return campusService.getCampus(nom);
    }

    @PostMapping
    public void createCampus(@RequestBody CampusDTO campusDTO) {
        campusService.createCampus(campusDTO);
    }
}