
package com.portfolio.SM9.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotNull
    @Size (min=1, max= 45, message = "longitud no válida")
    private String nombre;
    
    @NotNull
    @Size (min=1, max= 45, message = "longitud no válida")
    private String apellido;

    @Size (min=1, max= 45, message = "longitud no válida")
    private String img;
}
