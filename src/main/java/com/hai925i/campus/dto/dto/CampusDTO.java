package com.hai925i.campus.dto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CampusDTO {

    @NotBlank(message = "Le nom du campus est obligatoire")
    @Size(max = 16, message = "Le nom ne doit pas dépasser 16 caractères")
    private String nomC;

    @Size(max = 20, message = "La ville ne doit pas dépasser 20 caractères")
    private String ville;

    @NotBlank(message = "Le nom de l'université est obligatoire")
    private String nomUniversite;

    public CampusDTO() {
    }

    public CampusDTO(String nomC, String ville, String nomUniversite) {
        this.nomC = nomC;
        this.ville = ville;
        this.nomUniversite = nomUniversite;
    }

    public String getNomC() {
        return nomC;
    }

    public void setNomC(String nomC) {
        this.nomC = nomC;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getNomUniversite() {
        return nomUniversite;
    }

    public void setNomUniversite(String nomUniversite) {
        this.nomUniversite = nomUniversite;
    }
}