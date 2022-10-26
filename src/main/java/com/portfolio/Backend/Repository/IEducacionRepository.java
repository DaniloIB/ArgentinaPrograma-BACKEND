package com.portfolio.Backend.Repository;

import com.portfolio.Backend.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository<Educacion, Integer> {
    
    public Optional<Educacion> findByNombreEducacion( String nombreEducacion );
    
    public boolean existsByNombreEducacion( String nombreEducacion );
    
}
