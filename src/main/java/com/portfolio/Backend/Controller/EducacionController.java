package com.portfolio.Backend.Controller;

import com.portfolio.Backend.Dto.dtoEducacion;
import com.portfolio.Backend.Entity.Educacion;
import com.portfolio.Backend.Service.SEducacion;
import java.util.ArrayList;
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
@RequestMapping("educacion")
@CrossOrigin(origins="https://portfolio-argentinaprogr-cb632.web.app/")
/*@CrossOrigin(origins = "http://localhost:4200/")*/
public class EducacionController {
    
    @Autowired
    SEducacion sEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> lista = sEducacion.listaEducacion();       
        return new ResponseEntity( lista, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("La Educacion no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = sEducacion.traerEducacion(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }  
    
    @PostMapping("/create")
    public ResponseEntity<?> create( @RequestBody dtoEducacion dtoEducacion ){
        
        if(StringUtils.isBlank(dtoEducacion.getNombreEducacion()))
            return new ResponseEntity( new Mensaje("El nombre de Educacion es obligatorio."), HttpStatus.BAD_REQUEST);
        if( sEducacion.existsByNombreEducacion(dtoEducacion.getNombreEducacion()))
            return new ResponseEntity( new Mensaje("La educacion ya existe."), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = new Educacion(dtoEducacion.getNombreEducacion(), dtoEducacion.getInstitucion(), dtoEducacion.getPersonaId());
        sEducacion.save(educacion);
        return new ResponseEntity( new Mensaje("Educacion fue guardada exitosamente."), HttpStatus.OK);    
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update( @PathVariable("id") int id, @RequestBody dtoEducacion dtoEdu ){
        if(!sEducacion.existsById(id))
            return new ResponseEntity( new Mensaje("La Educacion con ese ID no existe."), HttpStatus.BAD_REQUEST);
        if(sEducacion.existsByNombreEducacion(dtoEdu.getNombreEducacion()) && sEducacion.getByNombreEducacion(dtoEdu.getNombreEducacion()).get().getId() != id)
            return new ResponseEntity( new Mensaje("La Educacion ya existe."), HttpStatus.BAD_REQUEST);  
    
        if(StringUtils.isBlank(dtoEdu.getNombreEducacion()))
            return new ResponseEntity( new Mensaje("El nombre de Educacion es obligatorio."), HttpStatus.BAD_REQUEST);
   
    Educacion educacion = sEducacion.traerEducacion(id).get();
        educacion.setNombreEducacion(dtoEdu.getNombreEducacion());
        educacion.setInstitucion(dtoEdu.getInstitucion());
        sEducacion.save(educacion);

        return new ResponseEntity( new Mensaje("Educacion actualizada correctamente.") , HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete( @PathVariable("id") int id){
        if(!sEducacion.existsById(id))
            return new ResponseEntity( new Mensaje("La Educacion con ese ID no existe."), HttpStatus.BAD_REQUEST);
        sEducacion.delete(id);
        return new ResponseEntity( new Mensaje("Educacion eliminada correctamente.") , HttpStatus.OK);
    }
    
    
    
}
