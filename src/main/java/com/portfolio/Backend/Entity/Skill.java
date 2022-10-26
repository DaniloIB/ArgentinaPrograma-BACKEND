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
@Table(name="skills")
public class Skill {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="nombre_skill")
    private String nombreSkill;
    
    private float porcentaje;
   
    @Column(name="persona_id")
    private int personaId;
    
    @ManyToOne
    @JoinColumn(name="persona_id", insertable = false, updatable = false)
    private Persona persona;
    
    
    //Constructor 

    public Skill() {
    }

    public Skill(String nombreSkill, float porcentaje, int personaId) {
        this.nombreSkill = nombreSkill;
        this.porcentaje = porcentaje;
        this.personaId = personaId;
    }

    
    
    //Getters & Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

  

    
    
}
