package com.hai925i.campus.controller;

import com.hai925i.campus.domain.UserRepository;
import com.hai925i.campus.model.Role;
import com.hai925i.campus.security.CustomUserDetails;
import com.hai925i.campus.service.CampusService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Collection;

@Controller
@RequestMapping("/users")
public class UserWebController {

    private final UserRepository userRepository;
    private final CampusService campusService;

    public UserWebController(UserRepository userRepository, CampusService campusService) {
        this.userRepository = userRepository;
        this.campusService = campusService;
    }

    @GetMapping
    public String listUsers(Model model,
                            Principal principal,
                            @RequestParam(required = false) Role roleFilter,
                            @RequestParam(required = false) String campusFilter) {
        // 1. Récupérer les infos de l'utilisateur connecté
        Authentication auth = (Authentication) principal;
        CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
        String nomUni = userDetails.getUniversiteNom();

        // 2. Vérifier son rôle
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        boolean isAdmin = authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
        boolean isProf = authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_ENSEIGNANT"));

        if (campusFilter != null && campusFilter.isEmpty()) campusFilter = null;

        // 3. Charger la liste selon le rôle
        if (isAdmin) {
            // L'admin voit tout le monde, avec filtres optionnels
            model.addAttribute("users", userRepository.searchUsers(nomUni, roleFilter, campusFilter));
            model.addAttribute("pageTitle", "Tous les utilisateurs");
        }
        else if (isProf) {
            // Le prof ne voit QUE les étudiants, mais peut filtrer par campus
            model.addAttribute("users", userRepository.searchUsers(nomUni, Role.etudiant, campusFilter));
            model.addAttribute("pageTitle", "Liste des Étudiants");
        }
        else {
            // Si c'est un étudiant qui force l'URL, on le renvoie au dashboard
            return "redirect:/dashboard";
        }

        model.addAttribute("campuses", campusService.getCampusesByUniversite(nomUni));
        model.addAttribute("nomUniversite", nomUni);
        model.addAttribute("currentRoleFilter", roleFilter);
        model.addAttribute("currentCampusFilter", campusFilter);
        return "users/list";
    }
}