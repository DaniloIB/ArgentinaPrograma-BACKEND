package com.portfolio.Backend.Controller;

import com.portfolio.Backend.Dto.dtoSkill;
import com.portfolio.Backend.Entity.Skill;
import com.portfolio.Backend.Service.SSkill;
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
@RequestMapping("skill")
@CrossOrigin(origins="https://portfolio-argentinaprogr-cb632.web.app/")
public class SkillController {

    @Autowired
    SSkill sSkill;

    @GetMapping("/lista")
    public ResponseEntity<List<Skill>> list() {
        List<Skill> lista = sSkill.listaSkills();
        return new ResponseEntity(lista, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int id){
        if(!sSkill.existsById(id))
            return new ResponseEntity(new Mensaje("El Skill no existe"), HttpStatus.NOT_FOUND);
        Skill skill = sSkill.traerSkill(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create( @RequestBody dtoSkill dtoSkill ){
        if( StringUtils.isBlank( dtoSkill.getNombreSkill()))
            return new ResponseEntity( new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
    
        if( sSkill.existsByNombreSkill(dtoSkill.getNombreSkill()))
            return new ResponseEntity( new Mensaje("El Skill ya existe."), HttpStatus.BAD_REQUEST);
        
        Skill skill = new Skill(dtoSkill.getNombreSkill(), dtoSkill.getPorcentaje(), dtoSkill.getPersonaId());
        sSkill.save(skill);
    
        return new ResponseEntity(new Mensaje("Skill agregado correctamente."), HttpStatus.OK);
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update( @PathVariable("id") int id, @RequestBody dtoSkill dtoSkill ){
    
        if(!sSkill.existsById(id))
            return new ResponseEntity( new Mensaje("El Skill con ese ID no existe."), HttpStatus.BAD_REQUEST);
    
        if(sSkill.existsByNombreSkill(dtoSkill.getNombreSkill()) && sSkill.getByNombreSkill(dtoSkill.getNombreSkill()).get().getId() != id)
            return new ResponseEntity( new Mensaje("El Skill ya existe."), HttpStatus.BAD_REQUEST);  
        
        if(StringUtils.isBlank(dtoSkill.getNombreSkill()))
            return new ResponseEntity( new Mensaje("El nombre del Skill es obligatorio."), HttpStatus.BAD_REQUEST);
    
        Skill skill = sSkill.traerSkill(id).get();
        skill.setNombreSkill(dtoSkill.getNombreSkill());
        skill.setPorcentaje(dtoSkill.getPorcentaje());
        skill.setPersonaId(dtoSkill.getPersonaId());       
        sSkill.save(skill);       
        return new ResponseEntity( new Mensaje("Skill actualizado correctamente.") , HttpStatus.OK);

    }
    
    
    @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> delete( @PathVariable("id") int id){
        if(!sSkill.existsById(id))
            return new ResponseEntity( new Mensaje("El Skill con ese ID no existe."), HttpStatus.BAD_REQUEST);
        sSkill.delete(id);
        return new ResponseEntity( new Mensaje("Skill eliminado correctamente.") , HttpStatus.OK);
        }
    
    
}
