package com.hai925i.campus.dto.dto;

import com.hai925i.campus.model.TypeSalle;

public class SalleDTO {
    private String numS;
    private int capacite;
    private TypeSalle typeS;
    private String acces;
    private String etage;
    private String codeBatiment;

    public SalleDTO() {}

    public SalleDTO(String numS, int capacite, TypeSalle typeS, String acces, String etage, String codeBatiment) {
        this.numS = numS;
        this.capacite = capacite;
        this.typeS = typeS;
        this.acces = acces;
        this.etage = etage;
        this.codeBatiment = codeBatiment;
    }

    public String getNumS() { return numS; }
    public void setNumS(String numS) { this.numS = numS; }

    public int getCapacite() { return capacite; }
    public void setCapacite(int capacite) { this.capacite = capacite; }

    public TypeSalle getTypeS() { return typeS; }
    public void setTypeS(TypeSalle typeS) { this.typeS = typeS; }

    public String getAcces() { return acces; }
    public void setAcces(String acces) { this.acces = acces; }

    public String getEtage() { return etage; }
    public void setEtage(String etage) { this.etage = etage; }

    public String getCodeBatiment() { return codeBatiment; }
    public void setCodeBatiment(String codeBatiment) { this.codeBatiment = codeBatiment; }
}