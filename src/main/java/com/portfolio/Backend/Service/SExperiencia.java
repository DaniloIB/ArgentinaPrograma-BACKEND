package com.portfolio.Backend.Service;

import com.portfolio.Backend.Entity.Experiencia;
import com.portfolio.Backend.Repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperiencia {

    @Autowired
    IExperienciaRepository iExperienciaRepository;

    public List<Experiencia> listaExperiencias() {
        return iExperienciaRepository.findAll();
    };
    
    public Optional<Experiencia> traerExperiencia(int id) {
        return iExperienciaRepository.findById(id);
    }
    
    public Optional<Experiencia> getByEmpresa(String empresa){
        return iExperienciaRepository.findByEmpresa(empresa);
    }
    
    public void save(Experiencia experiencia){
        iExperienciaRepository.save(experiencia);
    }
    
    public void delete( int id ){
        iExperienciaRepository.deleteById(id);
    }
    
    public boolean existsById( int id ){
        return iExperienciaRepository.existsById(id);
    }
    
    public boolean existsByEmpresa( String empresa ){
        return iExperienciaRepository.existsByEmpresa(empresa);
    }
    
    

}
