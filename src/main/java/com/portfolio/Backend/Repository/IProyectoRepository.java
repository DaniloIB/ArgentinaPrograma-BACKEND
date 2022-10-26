package com.portfolio.Backend.Repository;

import com.portfolio.Backend.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto, Integer> {
    public Optional<Proyecto> findByNombreProyecto(String nombreProyecto); 
    public boolean existsByNombreProyecto(String nombreProyecto);
}
