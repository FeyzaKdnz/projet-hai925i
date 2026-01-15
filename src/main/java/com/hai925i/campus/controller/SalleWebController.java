package com.hai925i.campus.controller;

import com.hai925i.campus.dto.dto.SalleDTO;
import com.hai925i.campus.security.CustomUserDetails;
import com.hai925i.campus.service.BatimentService;
import com.hai925i.campus.service.CampusService;
import com.hai925i.campus.service.SalleService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/salles")
public class SalleWebController {

    private final SalleService salleService;
    private final BatimentService batimentService;
    private final CampusService campusService;

    public SalleWebController(SalleService salleService, BatimentService batimentService, CampusService campusService) {
        this.salleService = salleService;
        this.batimentService = batimentService;
        this.campusService = campusService;
    }

    private String getNomUniversiteConnectee(Principal principal) {
        Authentication auth = (Authentication) principal;
        CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
        return user.getUniversiteNom();
    }

    @GetMapping
    public String listSalles(Model model,
                             Principal principal,
                             @RequestParam(required = false) String keyword,
                             @RequestParam(required = false) String etage,
                             @RequestParam(required = false) String acces,
                             @RequestParam(required = false) String batiment,
                             @RequestParam(required = false) String campus,
                             @RequestParam(required = false) Integer capMin) {

        String nomUni = getNomUniversiteConnectee(principal);

        if (keyword == null && etage == null && acces == null && batiment == null && campus == null && capMin == null) {
            model.addAttribute("salles", salleService.getSallesEntityByUniversite(nomUni));
        } else {
            if (keyword != null && keyword.isEmpty()) keyword = null;
            if (etage != null && etage.isEmpty()) etage = null;
            if (acces != null && acces.isEmpty()) acces = null;
            if (batiment != null && batiment.isEmpty()) batiment = null;
            if (campus != null && campus.isEmpty()) campus = null;
            if (capMin != null && capMin == 0) capMin = null;

            model.addAttribute("salles", salleService.searchSalles(keyword, etage, acces, batiment, campus, nomUni, capMin));
        }

        model.addAttribute("batiments", batimentService.findByUniversite(nomUni));
        model.addAttribute("campuses", campusService.getCampusesByUniversite(nomUni));
        model.addAttribute("keyword", keyword);
        model.addAttribute("selectedEtage", etage);
        model.addAttribute("selectedAcces", acces);
        model.addAttribute("selectedBatiment", batiment);
        model.addAttribute("selectedCampus", campus);
        model.addAttribute("capMin", capMin);

        return "salles/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model, Principal principal) {
        String nomUni = getNomUniversiteConnectee(principal);

        model.addAttribute("salleDTO", new SalleDTO());
        model.addAttribute("batiments", batimentService.findByUniversite(nomUni));
        return "salles/add";
    }

    @PostMapping("/save")
    public String saveSalle(@ModelAttribute SalleDTO salleDTO) {
        salleService.saveSalle(salleDTO);
        return "redirect:/salles";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model, Principal principal) {
        String nomUni = getNomUniversiteConnectee(principal);
        SalleDTO salleDTO = salleService.getSalleById(id);

        if (salleDTO == null) return "redirect:/salles";

        model.addAttribute("salleDTO", salleDTO);
        model.addAttribute("batiments", batimentService.findByUniversite(nomUni));
        return "salles/edit";
    }

    @PostMapping("/update")
    public String updateSalle(@ModelAttribute SalleDTO salleDTO) {
        salleService.saveSalle(salleDTO);
        return "redirect:/salles";
    }

    @GetMapping("/delete/{id}")
    public String deleteSalle(@PathVariable("id") String id) {
        salleService.deleteSalle(id);
        return "redirect:/salles";
    }
}