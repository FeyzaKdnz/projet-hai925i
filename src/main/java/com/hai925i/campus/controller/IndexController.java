package com.hai925i.campus.controller;

import com.hai925i.campus.security.CustomUserDetails;
import com.hai925i.campus.service.CampusService;
import com.hai925i.campus.service.SalleService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class IndexController { // Ou DashboardController

    private final CampusService campusService;
    private final SalleService salleService;

    public IndexController(CampusService campusService, SalleService salleService) {
        this.campusService = campusService;
        this.salleService = salleService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {

        // 1. Récupération de l'université de l'utilisateur connecté
        CustomUserDetails user = (CustomUserDetails) ((Authentication) principal).getPrincipal();
        String nomUniversite = user.getUniversiteNom(); // Assurez-vous d'avoir ajouté le getter dans CustomUserDetails

        // 2. Chargement des données FILTRÉES pour cette université uniquement
        model.addAttribute("nomUniversite", nomUniversite);
        model.addAttribute("campuses", campusService.getCampusDTOsByUniversite(nomUniversite));
        // model.addAttribute("nbCampus", ...); // Si besoin
        model.addAttribute("statsSalles", salleService.countSallesByTypeForCampus(nomUniversite)); // Adaptez si besoin la méthode de service

        // Attention : Vérifiez que 'countSallesByType' filtre bien par université ou campus
        // Si votre méthode countSallesByType ne prend pas d'argument, il faut en créer une qui filtre !

        return "dashboard";
    }
}