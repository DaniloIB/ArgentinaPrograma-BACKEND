package com.portfolio.Backend.Controller;

import com.portfolio.Backend.Dto.dtoPersona;
import com.portfolio.Backend.Entity.Persona;
import com.portfolio.Backend.Interface.IPersonaService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
/*@CrossOrigin(origins = "https://portfolio-argentinaprogr-cb632.web.app/")*/
@CrossOrigin(origins = "http://localhost:4200/")
public class PersonaController {

    @Autowired
    IPersonaService iPersonaService;

    @GetMapping("personas/traer")
    public List<Persona> getPersona() {
        return iPersonaService.getPersona();
    }

    ;
    
    
    @PostMapping("personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        iPersonaService.savePersona(persona);
        return "La persona fue creada correctamente.";
    }

    ;
    
    @DeleteMapping("personas/borrar/{id}")
    public String deletePersona(@PathVariable int id) {
        iPersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente.";
    }

    /*@PutMapping("personas/update/{id}")
    public Persona editPersona(
    @PathVariable int id,
    @RequestParam("nombre") String nuevoNombre,
    @RequestParam("apellido") String nuevoApellido,
    @RequestParam("ciudad") String nuevoCiudad,
    @RequestParam("pais") String nuevoPais,
    @RequestParam("urlFoto") String nuevoUrlFoto
    ){
        Persona persona = iPersonaService.findPersona(id);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setCiudad(nuevoCiudad);
        persona.setPais(nuevoPais);
        persona.setUrlFoto(nuevoUrlFoto);
        
        iPersonaService.savePersona(persona);
        
        return persona;
    }*/
    @PutMapping("personas/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtoPersona) {
        if (StringUtils.isBlank(dtoPersona.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre de Persona es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        Persona persona = iPersonaService.findPersona(id);
        persona.setNombre(dtoPersona.getNombre());
        persona.setApellido(dtoPersona.getApellido());
        persona.setCiudad(dtoPersona.getCiudad());
        persona.setPais(dtoPersona.getPais());
        persona.setUrlFoto(dtoPersona.getUrlFoto());

        iPersonaService.savePersona(persona);

        return new ResponseEntity(new Mensaje("Persona actualizada correctamente."), HttpStatus.OK);
    }

    @GetMapping("personas/traer/perfil")
    public Persona findPersona() {
        return iPersonaService.findPersona(1);

    }
}
