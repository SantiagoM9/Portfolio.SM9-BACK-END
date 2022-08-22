
package com.portfolio.SM9.Repository;

import com.portfolio.SM9.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository 
public interface RExperiencia extends JpaRepository<Experiencia, Integer> {
    
    // agrego dos metodos más aparte de los que hereda de Jpa
    
    public Optional <Experiencia> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
}
