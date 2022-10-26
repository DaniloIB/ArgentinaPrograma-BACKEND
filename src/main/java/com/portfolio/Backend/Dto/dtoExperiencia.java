package com.portfolio.Backend.Dto;

import javax.validation.constraints.NotBlank;

public class dtoExperiencia {

    @NotBlank
    private String empresa;
    @NotBlank
    private String puesto;
    @NotBlank
    private String descripcion;

    private int personaId;
    
    public dtoExperiencia() {
    }

    public dtoExperiencia(String empresa, String puesto, String descripcion, int personaId) {
        this.empresa = empresa;
        this.puesto = puesto;
        this.descripcion = descripcion;
        this.personaId = personaId;
    }
    
    

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    
    
}
