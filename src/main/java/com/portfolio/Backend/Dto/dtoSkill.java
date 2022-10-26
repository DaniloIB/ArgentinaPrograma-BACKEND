
package com.portfolio.Backend.Dto;

import javax.validation.constraints.NotBlank;


public class dtoSkill {
    @NotBlank
    private String nombreSkill;
    @NotBlank
    private float porcentaje;
    
    private Integer personaId;

    public dtoSkill() {
    }

    public dtoSkill(String nombreSkill, float porcentaje, Integer personaId) {
        this.nombreSkill = nombreSkill;
        this.porcentaje = porcentaje;
        this.personaId = personaId;
    }

    public String getNombreSkill() {
        return nombreSkill;
    }

    public void setNombreSkill(String nombreSkill) {
        this.nombreSkill = nombreSkill;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Integer getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }
    
    
    
    
    
}
