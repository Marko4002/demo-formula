package tim;

import java.io.Serializable;

public class Vozac extends Osoba implements Serializable {
    private static final long serialVersionUID =   12707697769540650L;
    
    private boolean imaUgovor = false;
    private int broj;
    private String nacionalnost;
    private boolean fiaLicenca = true;   
    
    
    
    
    public Vozac(String ime, String prezime) {
        super(ime, prezime);
    }
     
    // seteri
    
    public void setImaUgovor(boolean imaUgovor) {
        this.imaUgovor = imaUgovor;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }

    public void setNacionalnost(String nacionalnost) {
        this.nacionalnost = nacionalnost;
    }    

    public void setFiaLicenca(boolean fiaLicenca) {
        this.fiaLicenca = fiaLicenca;
    }
    
    // geteri    
    public String getImaUgovor() {
        if(imaUgovor)
            return "ima ugovor";
        else
            return "nema ugovor";
    }

    public int getBroj() {
        return broj;
    }

    public String getNacionalnost() {
        return nacionalnost;
    }    

    public boolean getFiaLicenca() {
        return fiaLicenca;
    }  
    
    // n
    /*@Override
    public String getIme() {
    return super.getIme();
    }*/
       
        
    
    @Override
    public String toString() {
        return getIme() + " " + getPrezime() + " " + getBroj();
    } 
    
    public String prikaziVozac() {
        return getIme() + " " + getPrezime() + ", " + getNacionalnost() + ", " 
             + getBroj() + ", " + getImaUgovor() + ", FIA licenca: " 
             + getFiaLicenca() + ", " + ", " + getUloga();
    
    }
    
}
