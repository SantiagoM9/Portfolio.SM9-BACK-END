
package com.portfolio.SM9.Service;

import com.portfolio.SM9.Entity.Experiencia;
import com.portfolio.SM9.Repository.RExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class SExperiencia {
    
    @Autowired      // Inyectar el Repositorio
     RExperiencia rExperiencia;
    
    // Traer todas las experiencias
    public List<Experiencia> list() {  
        return rExperiencia.findAll();
    }
    
    // Traer una experiencia por Id
    public Optional <Experiencia> getOne (int id) {
        return rExperiencia.findById(id);
    }
    
    // Traer una experiencia por nombre
    public Optional<Experiencia> getByNombreE (String nombreE) {
        return rExperiencia.findByNombreE(nombreE);
    }
    
    // Guarda una experiencia
    public void save(Experiencia expe) {
        rExperiencia.save(expe);
    }
    
    // Elimina una experiencia por id
    public void delete(int id) {
        rExperiencia.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return rExperiencia.existsById(id);
    }
    
    
    public boolean existsByNombreE (String nombreE) {
        return rExperiencia.existsByNombreE(nombreE);
    }
}
