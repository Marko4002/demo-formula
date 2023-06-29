package com.example.demo;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sezona.Staza;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class stazePrikazController implements Initializable {

    String info;

    @FXML
    private ListView lwStaze;
    @FXML
    private ImageView slikeStaze;

    @FXML
    public void editStazu() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("izmeniStazu.fxml"));
        Scene scene = new Scene(root);

        Formula.getStage().setScene(scene);
        Formula.setStage(Formula.getStage());

        System.out.println("Scena Dodaj/Sačuvaj Stazu postavljena.");
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Test");

        try {

            ucitajStaze();

            for(Staza staza : Formula.getStaze()) {

                if (staza.getNazivStaze().equals(lwStaze.getSelectionModel().getSelectedItem())) {
                    System.out.println(staza.getNazivStaze());
                    Image slika = new Image("C:\\Users\\Ucenik\\Downloads\\demo\\slike\\staze\\" + staza.getNazivStaze() + ".png");
                    System.out.println("test");
                    slikeStaze.setImage(slika);
                    info=staza.getNazivStaze() + " - " +
                            staza.getLokacija() + " - " +
                            staza.getDrzava();
                }
            }


        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(StazePrikaziController.class.getName()).log(Level.SEVERE, null, ex);
            System.getLogger(stazePrikazController.class.getName()).log(System.Logger.Level.OFF, (String) null, ex);
        }

        //    System.out.println(f1FXML.getStaze().isEmpty());

    }
    public void ucitajStaze() throws FileNotFoundException, IOException, ClassNotFoundException {

        ucitajIzFajla(new ObjectInputStream(new FileInputStream("staze.ser")));

        ArrayList<String> stazeNazivAL = new ArrayList();
        Formula.getStaze().forEach(s -> stazeNazivAL.add(s.getNazivStaze()));

        Formula.setStazeNazivOL(stazeNazivAL);
        lwStaze.setItems(Formula.getStazeNazivOL());
        lwStaze.getSelectionModel().selectFirst();
        System.out.println("Popunjen ListVew stazeLW");

        // System.out.println(f1FXML.getStaze().isEmpty());

    }

    public void ucitajIzFajla(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ArrayList<Staza> ucitanaLista = (ArrayList<Staza>) ois.readObject();
        Formula.setStaze(ucitanaLista);
        System.out.println(ucitanaLista.toString());
        System.out.println("Read file staze.ser" );
    }
    public void izaberiStazu(Event event) {
        //  System.out.println(f1FXML.getStaze().isEmpty());
        for (Staza staza : Formula.getStaze()) {
            if (staza.getNazivStaze().equals(lwStaze.getSelectionModel().getSelectedItem())) {
                Image slika = new Image("C:\\Users\\Ucenik\\Downloads\\demo\\slike\\staze\\" + staza.getNazivStaze() + ".png");
                Formula.trenutnaStaza=staza.getNazivStaze();
                slikeStaze.setImage(slika);
                info=staza.getNazivStaze() + " - " +
                        staza.getLokacija() + " - " +
                        staza.getDrzava();
                break;
            }
        }
    }
    public ListView getLW(){
        return this.lwStaze;
    }
}
