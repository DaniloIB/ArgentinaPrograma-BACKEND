package com.portfolio.Backend.Controller;

import com.portfolio.Backend.Dto.dtoAbout;
import com.portfolio.Backend.Entity.About;
import com.portfolio.Backend.Service.SAbout;
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
@RequestMapping("about")
/*@CrossOrigin(origins="https://portfolio-argentinaprogr-cb632.web.app/")*/
@CrossOrigin(origins = "http://localhost:4200/")
public class AboutController {

    @Autowired
    SAbout sAbout;

    @GetMapping("/detail/{id}")
    public ResponseEntity<About> getById(@PathVariable("id") int id) {
        if (!sAbout.existsById(id)) {
            return new ResponseEntity(new Mensaje("El dato no existe"), HttpStatus.NOT_FOUND);
        }
        About about = sAbout.traerAbout(id).get();
        return new ResponseEntity(about, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoAbout dtoAbout) {

        if (StringUtils.isBlank(dtoAbout.getTitular())) {
            return new ResponseEntity(new Mensaje("El titular es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        About about = new About(dtoAbout.getTitular(), dtoAbout.getDescripcion(), dtoAbout.getPersonaId());
        sAbout.save(about);
        return new ResponseEntity(new Mensaje("About fue guardado exitosamente."), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoAbout dtoAbout) {
        if (!sAbout.existsById(id)) {
            return new ResponseEntity(new Mensaje("El About con ese ID no existe."), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoAbout.getTitular())) {
            return new ResponseEntity(new Mensaje("El titular de About es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        About about = sAbout.traerAbout(id).get();
        about.setTitular(dtoAbout.getTitular());
        about.setDescripcion(dtoAbout.getDescripcion());
        sAbout.save(about);
        return new ResponseEntity(new Mensaje("About actualizado correctamente."), HttpStatus.OK);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete( @PathVariable("id") int id){
        if(!sAbout.existsById(id))
            return new ResponseEntity( new Mensaje("El About con ese ID no existe."), HttpStatus.BAD_REQUEST);
        sAbout.delete(id);
        return new ResponseEntity( new Mensaje("About eliminado correctamente.") , HttpStatus.OK);
    }

}
