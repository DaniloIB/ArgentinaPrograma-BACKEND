
package com.portfolio.Backend.Dto;

import javax.validation.constraints.NotBlank;


public class dtoAbout {
    
    
    @NotBlank
    private String titular;
    
    @NotBlank
    private String descripcion;
    
    private int personaId;

    public dtoAbout() {
    }

    public dtoAbout(String titular, String descripcion, int personaId) {
        this.titular = titular;
        this.descripcion = descripcion;
        this.personaId = personaId;
    }

    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }
    
    
    
}
