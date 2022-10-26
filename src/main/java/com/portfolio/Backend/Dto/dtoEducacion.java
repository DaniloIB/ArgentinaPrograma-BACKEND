package com.portfolio.Backend.Dto;

import javax.validation.constraints.NotBlank;
public class dtoEducacion {
    
    @NotBlank
    private String nombreEducacion;
    @NotBlank
    private String institucion;
    
    private int personaId;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreEducacion, String institucion, int personaId) {
        this.nombreEducacion = nombreEducacion;
        this.institucion = institucion;
        this.personaId = personaId;
    }

    public String getNombreEducacion() {
        return nombreEducacion;
    }

    public void setNombreEducacion(String nombreEducacion) {
        this.nombreEducacion = nombreEducacion;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }
    
    
    
}
