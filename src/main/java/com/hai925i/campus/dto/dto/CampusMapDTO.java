package com.hai925i.campus.dto.dto;

public class CampusMapDTO {
    private String nom;
    private Double latitude;
    private Double longitude;
    private String ville;

    public CampusMapDTO(String nom, Double latitude, Double longitude, String ville) {
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
        this.ville = ville;
    }

    public String getNom() { return nom; }
    public Double getLatitude() { return latitude; }
    public Double getLongitude() { return longitude; }
    public String getVille() { return ville; }
}