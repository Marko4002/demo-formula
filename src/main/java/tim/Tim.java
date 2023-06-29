package tim;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Outer klasa Tim
public class Tim implements Serializable {
    private static final long serialVersionUID =   -3329017151442793489L;

    private String nazivTima;

    private String sediste;   
    
    private Menadzer sefTima;
    
    private List<Vozac> vozac = new ArrayList();    
           
    
    
    // Konstruktor Outer klase
    public Tim(String nazivTima, String sediste/*, String sefTima*/) {
        this.nazivTima = nazivTima; 
       // this.sediste = sediste;
       // this.sefTima = sefTima;
    }
    
    // Seteri Outer klase
    public void setSefTima(Menadzer sefTima) {
        this.sefTima = sefTima;
    }
    
    public void setVozac(Vozac vozac) {   // dodajVozac
        this.vozac.add(vozac);      
    }   
    
    
    // Geteri Outer klase
    public String getNazivTima() {
        return nazivTima;
    } 
    
    public String getSediste() {
        return sediste;
    }
    
    public List<Vozac> getVozaci(){
        return vozac;
    }   
    
   
    @Override
    public String toString() {
        return "\nTim: " + nazivTima + ", " + "Konstruktor: " + konstruktor.getKonstruktor() 
                         + ", " + "Sef Tima: " + sefTima.getMenadzer()
             + ", \nVozači: " + vozac +  ", \nBolid: " + bolid.getBolid() 
             + ", \nSasija: " + bolid.getModelSasije();                
    }
    
    
    //Konstruktor Inner klase (napravljen zbog pistupa Inner klasi, inače nema potrebe za njim)
    public Konstruktor konstruktor = new Konstruktor();
    public Bolid bolid = new Bolid(); 
    
    
    // Inner klasa Konstruktor
public class Konstruktor implements Serializable{
        private String nazivKonstruktora;
        private String sediste;
        private String drzava;          
        
        // Konstruktori Inner klase
        public Konstruktor() {            
        }        
        
        public Konstruktor(String nazivKonstruktora, String sediste, String drzava) {
            konstruktor.nazivKonstruktora = nazivKonstruktora;
            konstruktor.sediste = sediste;
            konstruktor.drzava = drzava;
        }        
        
        // Geteri Inner klase
        public String getKonstruktor() {
            return  nazivKonstruktora + ", " + drzava;
        }                

        @Override
        public String toString() {
            return "Konstruktor: " + konstruktor.nazivKonstruktora + ", " 
                    + konstruktor.sediste + ", " + konstruktor.drzava; 
        } 
    } // kraj Inner klase Konstruktor 
    
    
    // Inner klasa Bolid
public class Bolid implements Serializable {
        private String bolidModel;
        private Sasija sasija;
        private String motor;
        private String menjac;
        private String gume;
        
        
        // Konstruktori Inner klase
        public Bolid() {            
        }

        public Bolid(String bolidModel, Sasija sasija, String motor, String menjac, String gume) {
            bolid.bolidModel = bolidModel;
            bolid.sasija = sasija;
            bolid.motor = motor;
            bolid.menjac = menjac;
            bolid.gume = gume;
        }
        
        public void setModelSasije(Sasija sasija) {
            bolid.sasija = sasija;
        }
        
        // Getteri Inner klase
        public String getBolid() {
            return  bolid.bolidModel;            
        }   
        
        public Sasija getModelSasije() {  // Lambda
            return bolid.sasija;
        } 
        

        @Override
        public String toString() {
            return "Bolid{" + "bolidModel=" + bolidModel + ", sasija=" + sasija + ", motor=" + motor + ", menjac=" + menjac + ", gume=" + gume + '}';
        }          
    } // kraj Inner klase Bolid    
   
} // kraj Outer klase Tim
