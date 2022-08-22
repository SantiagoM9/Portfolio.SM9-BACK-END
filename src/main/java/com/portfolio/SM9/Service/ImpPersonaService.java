
package com.portfolio.SM9.Service;

import com.portfolio.SM9.Entity.Persona;
import com.portfolio.SM9.Interface.IPersonaService;
import com.portfolio.SM9.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class ImpPersonaService implements IPersonaService {
    
    @Autowired IPersonaRepository ipersonaRespoitory;

    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonaRespoitory.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
       ipersonaRespoitory.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
    ipersonaRespoitory.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
      Persona persona = ipersonaRespoitory.findById(id).orElse(null);
        return persona;  
    }
    
   
}
