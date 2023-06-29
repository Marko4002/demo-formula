/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tim;

import java.io.Serializable;
import tim.Tim.Konstruktor;

/**
 *
 * @author CJ
 */
public class Sasija implements Serializable {
    private String modelSasije;
    private Konstruktor konstruktor;
    
    public Sasija(String modelSasije, Konstruktor konstruktor) {
        this.modelSasije = modelSasije;
        this.konstruktor = konstruktor;
    }
    
    
    
    

    @Override
    public String toString() {
        return  modelSasije  + "Konstruktor: " + konstruktor;
    }    
    
}
