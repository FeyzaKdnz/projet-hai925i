package com.hai925i.campus.dto.dto;

public class BatimentDTO {
    private String codeB;
    private int anneeC;
    private String nomCampus;

    public BatimentDTO() {}

    public BatimentDTO(String codeB, int anneeC, String nomCampus) {
        this.codeB = codeB;
        this.anneeC = anneeC;
        this.nomCampus = nomCampus;
    }

    public String getCodeB() { return codeB; }
    public void setCodeB(String codeB) { this.codeB = codeB; }

    public int getAnneeC() { return anneeC; }
    public void setAnneeC(int anneeC) { this.anneeC = anneeC; }

    public String getNomCampus() { return nomCampus; }
    public void setNomCampus(String nomCampus) { this.nomCampus = nomCampus; }
}