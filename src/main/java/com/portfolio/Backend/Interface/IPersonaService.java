package com.portfolio.Backend.Interface;

import com.portfolio.Backend.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    
    public List<Persona> getPersona();
    
    public void savePersona( Persona persona);
    
    public void deletePersona (int id);
    
    public Persona findPersona(int id);
    
}
