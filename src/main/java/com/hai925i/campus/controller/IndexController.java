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
public class IndexController {

    private final CampusService campusService;
    private final SalleService salleService;

    public IndexController(CampusService campusService, SalleService salleService) {
        this.campusService = campusService;
        this.salleService = salleService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        CustomUserDetails user = (CustomUserDetails) ((Authentication) principal).getPrincipal();
        String nomUniversite = user.getUniversiteNom();

        model.addAttribute("nomUniversite", nomUniversite);
        model.addAttribute("campuses", campusService.getCampusDTOsByUniversite(nomUniversite));
        model.addAttribute("statsSalles", salleService.countSallesByTypeForCampus(nomUniversite));

        return "dashboard";
    }
}