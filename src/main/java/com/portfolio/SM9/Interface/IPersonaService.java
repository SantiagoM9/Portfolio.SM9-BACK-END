
package com.portfolio.SM9.Interface;

import com.portfolio.SM9.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    
    // traer lista de personas    
    public List<Persona> getPersona();
    
    // guardar un objetivo de tipo Persona
    public void savePersona (Persona persona);
    
    // eliminar un objeto de tipo persona por Id
    public void deletePersona (Long id);
    
    // buscar persona por Id
    public Persona findPersona (Long id);
    
}

