package com.hai925i.campus.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "universite")
public class Universite {

    @Id
    @Column(length = 50)
    private String nom;

    @Column(length = 10)
    private String acronyme;

    private int creation;

    @Column(length = 50)
    private String presidence;

    @OneToMany(mappedBy = "universite", cascade = CascadeType.ALL)
    private Set<Campus> campusList = new HashSet<>();

    public Universite() {
    }

    public Universite(String nom, String acronyme, int creation, String presidence) {
        this.nom = nom;
        this.acronyme = acronyme;
        this.creation = creation;
        this.presidence = presidence;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAcronyme() {
        return acronyme;
    }

    public void setAcronyme(String acronyme) {
        this.acronyme = acronyme;
    }

    public int getCreation() {
        return creation;
    }

    public void setCreation(int creation) {
        this.creation = creation;
    }

    public String getPresidence() {
        return presidence;
    }

    public void setPresidence(String presidence) {
        this.presidence = presidence;
    }

    public Set<Campus> getCampusList() {
        return campusList;
    }

    public void setCampusList(Set<Campus> campusList) {
        this.campusList = campusList;
    }
}