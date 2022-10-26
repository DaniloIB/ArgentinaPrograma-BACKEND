package com.portfolio.Backend.Service;

import com.portfolio.Backend.Entity.Educacion;
import com.portfolio.Backend.Repository.IEducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEducacion{
    
    @Autowired
    IEducacionRepository iEducacionRepository;
    
    public List<Educacion> listaEducacion(){
        return iEducacionRepository.findAll();
    };
    
    public Optional<Educacion> traerEducacion( int id ){
        return iEducacionRepository.findById(id);
    }
    
    public Optional<Educacion> getByNombreEducacion( String nombreEducacion ){
        return iEducacionRepository.findByNombreEducacion(nombreEducacion);
    }
    
    public void save( Educacion educacion ){
        iEducacionRepository.save(educacion);
    }
    
    public void delete( int id ){
        iEducacionRepository.deleteById(id);
    }
    
    public boolean existsById( int id  ){
        return iEducacionRepository.existsById(id);
    }
    
    public boolean existsByNombreEducacion( String nombreEducacion ){
        return iEducacionRepository.existsByNombreEducacion(nombreEducacion);
    }
    
    
        
}
