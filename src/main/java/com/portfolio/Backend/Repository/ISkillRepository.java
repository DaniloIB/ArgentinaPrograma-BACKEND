package com.portfolio.Backend.Repository;

import com.portfolio.Backend.Entity.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillRepository extends JpaRepository<Skill, Integer>{
    public Optional<Skill> findByNombreSkill( String nombreSkill );
    
    public boolean existsByNombreSkill( String nombreSkill); 
}
