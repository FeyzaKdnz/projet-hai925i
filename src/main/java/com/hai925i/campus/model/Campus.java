package com.hai925i.campus.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "campus")
public class Campus {

    @Id
    @Column(length = 16)
    private String nomC;

    @Column(length = 20)
    private String ville;

    private Double latitude;
    private Double longitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_universite")
    private Universite universite;

    @OneToMany(mappedBy = "campus", cascade = CascadeType.ALL)
    private Set<Batiment> batiments = new HashSet<>();

    public Campus() {
    }

    public Campus(String nomC, String ville, Universite universite) {
        this.nomC = nomC;
        this.ville = ville;
        this.universite = universite;
    }

    public Campus(String nomC, String ville, Double latitude, Double longitude, Universite universite) {
        this.nomC = nomC;
        this.ville = ville;
        this.latitude = latitude;
        this.longitude = longitude;
        this.universite = universite;
    }

    public String getNomC() { return nomC; }
    public void setNomC(String nomC) { this.nomC = nomC; }
    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }
    public Universite getUniversite() { return universite; }
    public void setUniversite(Universite universite) { this.universite = universite; }
    public Set<Batiment> getBatiments() { return batiments; }
    public void setBatiments(Set<Batiment> batiments) { this.batiments = batiments; }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

}