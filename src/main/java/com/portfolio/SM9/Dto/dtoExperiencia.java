
package com.portfolio.SM9.Dto;

import javax.validation.constraints.NotBlank;


public class dtoExperiencia {
    
    @NotBlank
    private String nombreE;
    private String descrpicionE;

    
    // Constructores
    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String descrpicionE) {
        this.nombreE = nombreE;
        this.descrpicionE = descrpicionE;
    }
    
    
    // Getters and Seterrs
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
