package com.hai925i.campus.controller;

import com.hai925i.campus.dto.dto.SalleDTO;
import com.hai925i.campus.model.TypeSalle;
import com.hai925i.campus.service.SalleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/salles")
public class SalleDTORestController {

    private final SalleService salleService;

    public SalleDTORestController(SalleService salleService) {
        this.salleService = salleService;
    }

    @GetMapping
    public List<SalleDTO> getAllSalles() {
        return salleService.getAllSalles();
    }

    @GetMapping("/batiment/{codeBatiment}")
    public List<SalleDTO> getSallesByBatiment(@PathVariable String codeBatiment) {
        return salleService.getSallesByBatiment(codeBatiment);
    }

    @GetMapping("/stats/type")
    public Map<TypeSalle, Long> getStatsByType() {
        return salleService.countSallesByType();
    }

    @GetMapping("/stats/batiment")
    public Map<String, Long> getStatsByBatiment() {
        return salleService.countSallesByBatiment();
    }

    @GetMapping("/stats/campus/{nomCampus}")
    @ResponseBody
    public Map<String, Long> getStatsByCampus(@PathVariable String nomCampus) {
        return salleService.countSallesByTypeForCampus(nomCampus);
    }
}