package com.hai925i.campus.controller;

import com.hai925i.campus.service.UniversiteService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final UniversiteService universiteService;

    public LoginController(UniversiteService universiteService) {
        this.universiteService = universiteService;
    }

    /* ------ PAGE D'ACCUEIL : CHOIX DE L'UNIVERSITÉ ------ */

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("universites", universiteService.getAllUniversites());
        return "index"; // Affiche index.html (les cartes avec les universités)
    }

    /* ------ PAGE DE LOGIN (mémorise le choix de l'université) ------ */
    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false) String uni,
                            HttpSession session,
                            Model model) {

        if (uni != null) {
            session.setAttribute("TARGET_UNI_CODE", uni);
        }

        String targetUniAcronyme = (String) session.getAttribute("TARGET_UNI_CODE");

        // Retour à l'accueil si on force login (sécurité)
        if (targetUniAcronyme == null) {
            return "redirect:/";
        }

        model.addAttribute("nomUniversite", targetUniAcronyme);
        return "login";
    }
}