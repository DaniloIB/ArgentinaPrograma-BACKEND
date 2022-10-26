package com.portfolio.Backend.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="proyectos")
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="nombre_proyecto")
    private String nombreProyecto;
    
    private String descripcion;
    
    @Column(name="url_proyecto")
    private String urlProyecto;
    
    @Column(name="url_img")
    private String urlImg; 
    
    @Column(name="persona_id")
    private int personaId;
    
    @ManyToOne
    @JoinColumn(name="persona_id", insertable = false, updatable = false)
    private Persona persona;
    
    //Constructor

    public Proyecto() {
    }

    public Proyecto(String nombreProyecto, String descripcion, String urlProyecto, String urlImg, int personaId) {
        this.nombreProyecto = nombreProyecto;
        this.descripcion = descripcion;
        this.urlProyecto = urlProyecto;
        this.urlImg = urlImg;
        this.personaId = personaId;
    }

    

    
    
    //Getters & Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
