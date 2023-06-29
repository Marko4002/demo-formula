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


public class Osoba implements Serializable{
    private static final long serialVersionUID =  1630105262039454129L;
    
    String ime;
    private String prezime;
    private String datRodj;    
    private String adresa;
    private Uloga uloga;
    
    public enum Uloga { //public? ok
        TEAMPRINCIPAL, SPORTINGDIRECTOR, TEHNICALDIRECTOR, TEAMMANAGER, RACEENGEINEER,
        DRIVERFIRST, DRIVERSECOND, DRIVERTHIRD, DRIVERTEST, DRIVERRESERVED,
    }
    
    public Osoba(String ime, String prezime, Uloga uloga) {
        this.ime = ime;
        this.prezime = prezime; 
        this.uloga = uloga;
    }
   public Osoba(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;              
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }   

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }
    
    public String getImeIPrezime() {
        return ime + prezime;
    }
    
    public String getUloga() {
        switch (uloga) {
            case TEAMPRINCIPAL:
                return "Šef tima: ";               
                    
            case SPORTINGDIRECTOR:
                return "Sportski direktor: ";
                         
            case TEHNICALDIRECTOR:
                return "Tehnički direktor: ";
                
            case TEAMMANAGER:
                return "Tim menadžer: ";  
                
            case RACEENGEINEER:
                return "Menadžer trke: ";    
                        
            case DRIVERFIRST:
                return "Prvi vozač: ";
                
            case DRIVERSECOND:
                return "Drugi vozač: ";
                
            case DRIVERTHIRD:
                return "Treći vozač: "; 
                
            case DRIVERTEST:
                return "Testni vozač: "; 
                
            case DRIVERRESERVED:
                return "Rezervni vozač: ";     
            
            default:
                return "Ne postoji uloga!";
        }        
    } 
    
    // n
    public String getUloga1() {
        return uloga.toString();
    }
    
    @Override
    public String toString() {
        return getUloga() + " " + getIme() + " " + getPrezime();
    }  
    
}
