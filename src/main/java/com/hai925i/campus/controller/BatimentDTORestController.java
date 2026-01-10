package com.hai925i.campus.controller;

import com.hai925i.campus.dto.dto.BatimentDTO;
import com.hai925i.campus.service.BatimentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/batiments")
public class BatimentDTORestController {

    private final BatimentService batimentService;

    public BatimentDTORestController(BatimentService batimentService) {
        this.batimentService = batimentService;
    }

    // GET http://localhost:8080/api/batiments
    @GetMapping
    public List<BatimentDTO> getAllBatiments() {
        return batimentService.getAllBatiments();
    }

    // GET http://localhost:8080/api/batiments/campus/Triolet
    @GetMapping("/campus/{nomCampus}")
    public List<BatimentDTO> getBatimentsByCampus(@PathVariable String nomCampus) {
        return batimentService.getBatimentsByCampus(nomCampus);
    }

    @GetMapping("/universite/{nomUniversite}")
    public List<BatimentDTO> getBatimentsByUniversite(@PathVariable String nomUniversite) {
        return batimentService.getBatimentByUniversite(nomUniversite);
    }
}