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
@Table(name="educacion")
public class Educacion {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="nombre_educacion")
    private String nombreEducacion;
    
    private String institucion;
    
    @Column(name="persona_id")
    private int personaId;
    
    @ManyToOne
    @JoinColumn(name="persona_id", insertable = false, updatable = false)
    private Persona persona;
    
    //Constructor

    public Educacion() {
    }

    public Educacion(String nombreEducacion, String institucion, Integer personaId) {
        this.nombreEducacion = nombreEducacion;
        this.institucion = institucion;
        this.personaId = personaId;
    }

    
    //Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }   
    
    
    
}
