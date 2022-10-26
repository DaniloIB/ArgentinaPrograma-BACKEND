package com.portfolio.Backend.Dto;

import javax.validation.constraints.NotBlank;

public class dtoProyecto {
    
    @NotBlank
    private String nombreProyecto;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String urlProyecto;
    @NotBlank
    private String urlImg; 
    
    private int personaId;

    public dtoProyecto() {
    }
    
    public dtoProyecto(String nombreProyecto, String descripcion, String urlProyecto, String urlImg, int personaId) {
        this.nombreProyecto = nombreProyecto;
        this.descripcion = descripcion;
        this.urlProyecto = urlProyecto;
        this.urlImg = urlImg;
        this.personaId = personaId;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlProyecto() {
        return urlProyecto;
    }

    public void setUrlProyecto(String urlProyecto) {
        this.urlProyecto = urlProyecto;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }
    
    
    
}
