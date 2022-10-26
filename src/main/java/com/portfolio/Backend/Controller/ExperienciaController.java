package com.portfolio.Backend.Controller;

import com.portfolio.Backend.Dto.dtoExperiencia;
import com.portfolio.Backend.Entity.Experiencia;
import com.portfolio.Backend.Service.SExperiencia;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("experiencia")
@CrossOrigin(origins="http://localhost:4200")
public class ExperienciaController {
    
    @Autowired
    SExperiencia sExperiencia;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> lista = sExperiencia.listaExperiencias();
        return new ResponseEntity( lista, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("La Experiencia no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = sExperiencia.traerExperiencia(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create( @RequestBody dtoExperiencia dtoExp ){
        if( StringUtils.isBlank( dtoExp.getEmpresa()))
            return new ResponseEntity( new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        if( sExperiencia.existsByEmpresa(dtoExp.getEmpresa()))
            return new ResponseEntity( new Mensaje("La experiencia ya existe."), HttpStatus.BAD_REQUEST);
        
        Experiencia exp = new Experiencia(dtoExp.getEmpresa(), dtoExp.getPuesto(), dtoExp.getDescripcion(), dtoExp.getPersonaId());
        sExperiencia.save(exp);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada correctamente."), HttpStatus.OK);
    }
   
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update( @PathVariable("id") int id, @RequestBody dtoExperiencia dtoExp ){
        if(!sExperiencia.existsById(id))
            return new ResponseEntity( new Mensaje("La Experiencia con ese ID no existe."), HttpStatus.BAD_REQUEST);
        if(sExperiencia.existsByEmpresa(dtoExp.getEmpresa()) && sExperiencia.getByEmpresa(dtoExp.getEmpresa()).get().getId() != id)
            return new ResponseEntity( new Mensaje("La Empresa ya existe."), HttpStatus.BAD_REQUEST);  
        if(StringUtils.isBlank(dtoExp.getEmpresa()))
            return new ResponseEntity( new Mensaje("El nombre de Empresa es obligatorio."), HttpStatus.BAD_REQUEST);

        Experiencia experiencia = sExperiencia.traerExperiencia(id).get();
        experiencia.setEmpresa(dtoExp.getEmpresa());
        experiencia.setPuesto(dtoExp.getPuesto());
        experiencia.setDescripcion(dtoExp.getDescripcion());
        sExperiencia.save(experiencia);

        return new ResponseEntity( new Mensaje("Experiencia actualizada correctamente.") , HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete( @PathVariable("id") int id){
        if(!sExperiencia.existsById(id))
            return new ResponseEntity( new Mensaje("La Experiencia con ese ID no existe."), HttpStatus.BAD_REQUEST);
        sExperiencia.delete(id);
        return new ResponseEntity( new Mensaje("Experiencia eliminada correctamente.") , HttpStatus.OK);
    }
    
    
    
    
}
