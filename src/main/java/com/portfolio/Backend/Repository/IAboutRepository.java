
package com.portfolio.Backend.Repository;

import com.portfolio.Backend.Entity.About;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAboutRepository extends JpaRepository<About, Integer> {
       public Optional<About> findByPersonaId( int personaId );
}
