package com.hai925i.campus.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "batiment")
public class Batiment {

    @Id
    @Column(length = 16)
    private String codeB;

    @Column(name = "anneeC")
    private int anneeConstruction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campus")
    private Campus campus;

    @OneToMany(mappedBy = "batiment", cascade = CascadeType.ALL)
    private Set<Salle> salles = new HashSet<>();

    @ManyToMany(mappedBy = "batimentsExploites")
    private Set<Composante> composantes = new HashSet<>();

    public Batiment() {
    }

    public Batiment(String codeB, int anneeConstruction, Campus campus) {
        this.codeB = codeB;
        this.anneeConstruction = anneeConstruction;
        this.campus = campus;
    }

    public String getCodeB() {
        return codeB;
    }

    public void setCodeB(String codeB) {
        this.codeB = codeB;
    }

    public int getAnneeConstruction() {
        return anneeConstruction;
    }

    public void setAnneeConstruction(int anneeConstruction) {
        this.anneeConstruction = anneeConstruction;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public Set<Salle> getSalles() {
        return salles;
    }

    public void setSalles(Set<Salle> salles) {
        this.salles = salles;
    }

    public Set<Composante> getComposantes() {
        return composantes;
    }

    public void setComposantes(Set<Composante> composantes) {
        this.composantes = composantes;
    }
}