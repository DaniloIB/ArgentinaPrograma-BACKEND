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
@Table(name="experiencias")
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String empresa;
    
    private String puesto;
    
    private String descripcion;
    
    @Column(name="persona_id")
    private int personaId;
   
    @ManyToOne
    @JoinColumn(name="persona_id", insertable = false, updatable = false)
    private Persona persona;
    
    //Constructor 

    public Experiencia() {
    }

    public Experiencia(String empresa, String puesto, String descripcion, int personaId) {
        this.empresa = empresa;
        this.puesto = puesto;
        this.descripcion = descripcion;
        this.personaId = personaId;
    }
   
    
    //Getters and Setters

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
