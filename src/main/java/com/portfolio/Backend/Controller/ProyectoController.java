
package com.portfolio.Backend.Controller;

import com.portfolio.Backend.Dto.dtoProyecto;
import com.portfolio.Backend.Entity.Proyecto;
import com.portfolio.Backend.Service.SProyecto;
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
@RequestMapping("proyecto")
/*@CrossOrigin(origins="https://portfolio-argentinaprogr-cb632.web.app/")*/
@CrossOrigin(origins = "http://localhost:4200/")
public class ProyectoController {
    
    @Autowired
    SProyecto sProyecto;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> lista = sProyecto.listaProyectos();
        return new ResponseEntity( lista, HttpStatus.OK);
    }
    
     @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!sProyecto.existsById(id))
            return new ResponseEntity(new Mensaje("El Proyecto no existe"), HttpStatus.NOT_FOUND);
        Proyecto proyecto = sProyecto.traerProyecto(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    
    @PostMapping("/create")
    public ResponseEntity<?> create( @RequestBody dtoProyecto dtoPro ){
    if( StringUtils.isBlank( dtoPro.getNombreProyecto()))
            return new ResponseEntity( new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
    
    if( sProyecto.existsByNombreProyecto(dtoPro.getNombreProyecto()))
            return new ResponseEntity( new Mensaje("El Proyecto ya existe."), HttpStatus.BAD_REQUEST);
    
    Proyecto proyecto = new Proyecto(dtoPro.getNombreProyecto(), dtoPro.getDescripcion(), dtoPro.getUrlProyecto(), dtoPro.getUrlImg(), dtoPro.getPersonaId());
        sProyecto.save(proyecto);       
        return new ResponseEntity(new Mensaje("Proyecto agregado correctamente."), HttpStatus.OK);
    }
    
     @PutMapping("/update/{id}")
    public ResponseEntity<?> update( @PathVariable("id") int id, @RequestBody dtoProyecto dtoPro ){
    
    if(!sProyecto.existsById(id))
            return new ResponseEntity( new Mensaje("El Proyecto con ese ID no existe."), HttpStatus.BAD_REQUEST);
    
    
    if(sProyecto.existsByNombreProyecto(dtoPro.getNombreProyecto()) && sProyecto.getByNombreProyecto(dtoPro.getNombreProyecto()).get().getId() != id)
            return new ResponseEntity( new Mensaje("El Proyecto ya existe."), HttpStatus.BAD_REQUEST);  
    
    if(StringUtils.isBlank(dtoPro.getNombreProyecto()))
            return new ResponseEntity( new Mensaje("El nombre del Proyecto es obligatorio."), HttpStatus.BAD_REQUEST);
    
    
    Proyecto proyecto = sProyecto.traerProyecto(id).get();
        proyecto.setNombreProyecto(dtoPro.getNombreProyecto());
        proyecto.setDescripcion(dtoPro.getDescripcion());
        proyecto.setUrlProyecto(dtoPro.getUrlProyecto());
        proyecto.setUrlImg(dtoPro.getUrlImg());
        sProyecto.save(proyecto);

        return new ResponseEntity( new Mensaje("Proyecto actualizado correctamente.") , HttpStatus.OK);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete( @PathVariable("id") int id){
        if(!sProyecto.existsById(id))
            return new ResponseEntity( new Mensaje("El Proyecto con ese ID no existe."), HttpStatus.BAD_REQUEST);
        sProyecto.delete(id);
        return new ResponseEntity( new Mensaje("Proyecto eliminado correctamente.") , HttpStatus.OK);
    }
    
    
}
