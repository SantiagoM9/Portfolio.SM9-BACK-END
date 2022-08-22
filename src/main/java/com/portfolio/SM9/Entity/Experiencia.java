
package com.portfolio.SM9.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombreE;
    private String descrpicionE;

    
    // Constructores
    public Experiencia() {
    }

    public Experiencia(String nombreE, String descrpiciónE) {
        this.nombreE = nombreE;
        this.descrpicionE = descrpiciónE;
    }
    
    // Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescrpicionE() {
        return descrpicionE;
    }

    public void setDescrpicionE(String descrpicionE) {
        this.descrpicionE = descrpicionE;
    }
    
}
