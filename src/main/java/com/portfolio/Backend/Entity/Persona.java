package com.portfolio.Backend.Entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="personas")
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private String ciudad;
    private String pais;
    @Column(name = "url_foto")
    private String urlFoto;
    
    @OneToMany(mappedBy = "persona")
    private List<About> about;
    
    @OneToMany(mappedBy = "persona")
    private List<Educacion> educaciones;
    
    @OneToMany(mappedBy = "persona")
    private List<Experiencia> experiencias;
    
    @OneToMany(mappedBy = "persona")
    private List<Proyecto> proyectos;
    
    @OneToMany(mappedBy = "persona")
    private List<Skill> skills;
    
    //Constructor
    public Persona() {
    }

    public Persona(String nombre, String apellido, String ciudad, String pais, Integer usuarioId, String urlFoto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.pais = pais;
        this.urlFoto = urlFoto;

    }


    //Getters and Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<About> getAbout() {
        return about;
    }

    public void setAbout(List<About> about) {
        this.about = about;
    }
    
    

    public List<Educacion> getEducaciones() {
        return educaciones;
    }

    public void setEducaciones(List<Educacion> educaciones) {
        this.educaciones = educaciones;
    }

    public List<Experiencia> getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(List<Experiencia> experiencias) {
        this.experiencias = experiencias;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

   
    
    
}
