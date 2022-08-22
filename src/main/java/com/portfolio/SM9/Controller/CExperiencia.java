
package com.portfolio.SM9.Controller;


import com.portfolio.SM9.Dto.dtoExperiencia;
import com.portfolio.SM9.Entity.Experiencia;
import com.portfolio.SM9.Service.SExperiencia;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("explab")
@CrossOrigin (origins = "http://localhost:4200")
public class CExperiencia {
    
    @Autowired
    SExperiencia sExperiencia;
    
    @GetMapping ("/lista")
    public ResponseEntity <List<Experiencia>> list () {
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity (list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @PostMapping ("/create")
    public ResponseEntity <?> create(@RequestBody dtoExperiencia dtoexp) {
        if (StringUtils.isBlank(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("Se debe asignar un nombre"), HttpStatus.BAD_REQUEST);
        if (sExperiencia.existsByNombreE(dtoexp.getNombreE()))
            return new ResponseEntity (new Mensaje("Experiencia repetida"),HttpStatus.BAD_REQUEST );
        
        Experiencia experiencia = new Experiencia (dtoexp.getNombreE(), dtoexp.getDescrpicionE());
        sExperiencia.save(experiencia);
       
        return new ResponseEntity (new Mensaje("Experiencia laboral agregada"), HttpStatus.OK);
    }
    
    @PutMapping ("/update/{id} ")
    public ResponseEntity<?> update (@PathVariable ("id") int id, @RequestBody dtoExperiencia dtoexp) {
        if (!sExperiencia.existsById(id))
            return new ResponseEntity (new Mensaje("Id inexistente"),HttpStatus.BAD_REQUEST );
        
        if (sExperiencia.existsByNombreE(dtoexp.getNombreE()) && sExperiencia.getByNombreE(dtoexp.getNombreE().get().getId() != id))
        return new ResponseEntity(new Mensaje("Experiencia repetida"),HttpStatus.BAD_REQUEST ); 
   
    if (StringUtils.isBlank(dtoexp.getNombreE()))
    return new ResponseEntity(new Mensaje("Nombre obligatorio"),HttpStatus.BAD_REQUEST );
    
    Experiencia experiencia = sExperiencia.getOne(id).get();
    
    experiencia.setNombreE(dtoexp.getNombreE());
    experiencia.setDescrpicionE(dtoexp.getDescrpicionE());
    
    sExperiencia.save(experiencia);
    return new ResponseEntity (new Mensaje("Experiencia laboral actualizada"), HttpStatus.OK); 
    
    }
    
    
    @DeleteMapping ("/delete/{id}")
    
    public ResponseEntity<?> delete (@PathVariable ("id") int id){
       
        if (!sExperiencia.existsById(id))
            return new ResponseEntity (new Mensaje("Id inexistente"),HttpStatus.BAD_REQUEST ); 
        sExperiencia.delete(id);
        return new ResponseEntity (new Mensaje("Experiencia eliminada"), HttpStatus.OK); 
        
    }
    
}