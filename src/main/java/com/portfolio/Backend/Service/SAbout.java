
package com.portfolio.Backend.Service;

import com.portfolio.Backend.Entity.About;
import com.portfolio.Backend.Repository.IAboutRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SAbout {
    
    @Autowired
    IAboutRepository iAboutRepository;
    
    public Optional<About> traerAbout( int id ){
        return iAboutRepository.findById(id);
    }
    
    public void save ( About about ){
        iAboutRepository.save(about);
    }
    
    public void delete( int id ){
        iAboutRepository.deleteById(id);
    }
    
    public boolean existsById( int id){
        return iAboutRepository.existsById(id);
    }

}
