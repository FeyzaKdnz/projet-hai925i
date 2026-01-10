package com.hai925i.campus.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "composante")
public class Composante {

    @Id
    @Column(length = 8)
    private String acronyme;

    @Column(length = 100)
    private String nom;

    @Column(length = 50)
    private String responsable;

    @ManyToMany
    @JoinTable(
            name = "exploite",
            joinColumns = @JoinColumn(name = "team"),
            inverseJoinColumns = @JoinColumn(name = "building")
    )
    private Set<Batiment> batimentsExploites = new HashSet<>();

    public Composante() {
    }

    public Composante(String acronyme, String nom, String responsable) {
        this.acronyme = acronyme;
        this.nom = nom;
        this.responsable = responsable;
    }

    // Getters et Setters
    public String getAcronyme() {
        return acronyme;
    }

    public void setAcronyme(String acronyme) {
        this.acronyme = acronyme;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public Set<Batiment> getBatimentsExploites() {
        return batimentsExploites;
    }

    public void setBatimentsExploites(Set<Batiment> batimentsExploites) {
        this.batimentsExploites = batimentsExploites;
    }
}