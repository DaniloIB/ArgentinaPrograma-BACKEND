package com.portfolio.Backend.Service;

import com.portfolio.Backend.Entity.Skill;
import com.portfolio.Backend.Repository.ISkillRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SSkill {
    
    @Autowired
    ISkillRepository iSkillRepository;
    
    
    public List<Skill> listaSkills(){
        return iSkillRepository.findAll();
    }
    
    public Optional<Skill> traerSkill( int id ){
        return iSkillRepository.findById(id);
    }
    
    public Optional<Skill> getByNombreSkill( String nombreSkill){
          return iSkillRepository.findByNombreSkill(nombreSkill);
    }
    
    public void save( Skill skill ){
        iSkillRepository.save(skill);
    }
    
    public void delete( int id ){
        iSkillRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
       return iSkillRepository.existsById(id);
    }
    
    public boolean existsByNombreSkill( String nombreSkill ){
        return iSkillRepository.existsByNombreSkill(nombreSkill);
    }
}
