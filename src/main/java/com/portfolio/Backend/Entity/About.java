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
@Table(name="about")
public class About {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    private String titular;
    private String descripcion;
    
    @Column(name="persona_id")
    private int personaId;
    
    @ManyToOne
    @JoinColumn(name="persona_id", insertable = false, updatable = false)
    private Persona persona;
    
    //Constructor

    public About() {
    }

    public About(String titular, String descripcion, int personaId) {
        this.titular = titular;
        this.descripcion = descripcion;
        this.personaId = personaId;
    }


   //Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
