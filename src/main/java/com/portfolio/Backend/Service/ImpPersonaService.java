package com.portfolio.Backend.Service;

import com.portfolio.Backend.Entity.Persona;
import com.portfolio.Backend.Interface.IPersonaService;
import com.portfolio.Backend.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IPersonaService {

    @Autowired
    IPersonaRepository iPersonaRepository;
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = iPersonaRepository.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        iPersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(int id) {
        iPersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(int id) {
        Persona perso = iPersonaRepository.findById(id).orElse(null);
        return perso;
    }
    
    
    
}
