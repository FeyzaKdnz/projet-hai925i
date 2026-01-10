package com.hai925i.campus.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUserDetails extends User {

    private final String universiteNom;

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, String universiteNom) {
        super(username, password, authorities);
        this.universiteNom = universiteNom;
    }

    public String getUniversiteNom() {
        return universiteNom;
    }
}