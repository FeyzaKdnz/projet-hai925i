package com.hai925i.campus.service;

import com.hai925i.campus.domain.UserRepository;
import com.hai925i.campus.model.User;
import com.hai925i.campus.security.CustomUserDetails;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur inconnu : " + username));

        // --- VERIFICATION DE L'UNIVERSITE ---
        // On récupère la session HTTP actuelle pour voir quelle université a été choisi, si elle n'existe pas on ne la crée pas (false)
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(false);

        if (session != null) {
            String targetUniAcronyme = (String) session.getAttribute("TARGET_UNI_CODE");

            // Si l'utilisateur a une université assignée, on vérifie qu'elle correspond au choix
            if (user.getUniversite() != null && targetUniAcronyme != null) {
                String userUniAcronyme = user.getUniversite().getAcronyme();

                if (!userUniAcronyme.equalsIgnoreCase(targetUniAcronyme)) {
                    throw new UsernameNotFoundException("Accès refusé : Vous n'appartenez pas à l'université (" + targetUniAcronyme + ").");
                }
            }
        }

        String roleName = user.getRole().name().toUpperCase();
        String nomUniversite = (user.getUniversite() != null) ? user.getUniversite().getNom() : null;

        return new CustomUserDetails(
                user.getUsername(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + roleName)),
                nomUniversite
        );
    }
}