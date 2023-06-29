/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tim;

import java.io.Serializable;

/**
 *
 * @author CJ
 */
public class Menadzer extends Osoba implements Serializable{  
    
    public Menadzer(String ime, String prezime, Uloga uloga) {
        super(ime, prezime, uloga);       
    }   

    
    public String getMenadzer() {
        return super.getIme() + " " + super.getPrezime();
    }
 /*   @Override
    public String toString() {
        return super.getUloga() + " " + super.getIme() + " " + super.getPrezime();
    }   */
        
}
