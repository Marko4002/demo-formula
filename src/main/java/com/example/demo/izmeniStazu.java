package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sezona.Staza;

import java.io.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class izmeniStazu implements Initializable {
    @FXML
    private ImageView slikaIzmenaS;
    @FXML
    private TextField tf1;
     static Path path=null;
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        for (Staza staza : Formula.getStaze()) {
            if (staza.getNazivStaze().equals(Formula.trenutnaStaza)) {
                Image slika = new Image("C:\\Users\\Ucenik\\Downloads\\demo\\slike\\staze\\" + staza.getNazivStaze() + ".png");

                slikaIzmenaS.setImage(slika);
                tf1.setText(staza.getNazivStaze() + " - " +
                        staza.getLokacija() + " - " +
                        staza.getDrzava());
                break;
            }
        }
    }
    @FXML
    public void dodaj() throws IOException {
        Staza novaStaza ;
        String tep[] = new String[3];
        tep = tf1.getText().split(" - ");
        novaStaza=new Staza(tep[0], tep[1], tep[2], null, 0.00, null);
        Formula.getStaze().add(novaStaza);
        Formula.getStazeNazivOL().add(novaStaza.getNazivStaze());
        System.out.println(novaStaza.getNazivStaze());
        zapisi();
        saveToFile(novaStaza.getNazivStaze());
        Parent root = FXMLLoader.load(getClass().getResource("stazePrikaz.fxml"));
        Scene scene = new Scene(root);

        Formula.getStage().setScene(scene);
        Formula.setStage(Formula.getStage());
    }

    public void izaberiSliku() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File imageFile = fileChooser.showOpenDialog(new Stage());

        if (imageFile.getPath().contains(".png") && imageFile.exists()) {
            slikaIzmenaS.setImage(new Image(imageFile.getPath()));
            path= imageFile.toPath();
        }
    }

    public void Izbrisi() throws IOException {
        ArrayList<Staza> stazeNovi = new ArrayList<Staza>();
        ArrayList<String> stazeNazivAL = new ArrayList();
        for (Staza staza : Formula.getStaze()) {
            if (!staza.getNazivStaze().equals(Formula.trenutnaStaza)) {
                stazeNovi.add(staza);
            }
        }
        stazeNovi.forEach(s -> stazeNazivAL.add(s.getNazivStaze()));
        Formula.setStazeNazivOL(stazeNazivAL);
        Formula.setStaze(stazeNovi);
        zapisi();
        System.out.println(Formula.getStaze());
        Parent root = FXMLLoader.load(getClass().getResource("stazePrikaz.fxml"));
        Scene scene = new Scene(root);

        Formula.getStage().setScene(scene);
        Formula.setStage(Formula.getStage());
        System.out.println("Izbrisana je staza");
    }

    private void zapisi() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("staze.ser"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.writeObject(Formula.getStaze());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void izmeni() throws IOException {
        for (Staza staza : Formula.getStaze()) {
            if (staza.getNazivStaze().equals(Formula.trenutnaStaza)) {
                //Formula.getStaze().remove(staza);
                Path ph = Paths.get(slikaIzmenaS.getImage().getUrl());


                String tep[] = new String[3];
                tep = tf1.getText().split(" - ");
                System.out.println(ph.getFileName().toString());
                if(!ph.getFileName().toString().equals(tep[0]+".png"))
                    saveToFile(tep[0], ph);
                staza.setStaza(tep[0], tep[1], tep[2]);

                Formula.getStazeNazivOL().set(Formula.getStaze().indexOf(staza), tep[0]);
                if(path!=null)
                saveToFile();


                //   scene.getStylesheets().add(f1FXML.class.getResource("F1.css").toExternalForm());
                zapisi();
                System.out.println("Staza je izmenjena " + staza.getNazivStaze()+staza.getDrzava()+staza.getLokacija());
                System.out.println(staza.getNazivStaze());
                Parent root = FXMLLoader.load(getClass().getResource("stazePrikaz.fxml"));
                Scene scene = new Scene(root);

                Formula.getStage().setScene(scene);
                Formula.setStage(Formula.getStage());
            }
        }

    }
    public static void saveToFile() throws IOException {
        Path from = path;
        Path to = Paths.get("C:\\Users\\Ucenik\\Downloads\\demo\\slike\\staze\\" + Formula.trenutnaStaza + ".png");
        CopyOption[] options = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES
        };
        Files.copy(from, to, options);
    }
    public static void saveToFile(String s) throws IOException {
        Path from = path;
        Path to = Paths.get("C:\\Users\\Ucenik\\Downloads\\demo\\slike\\staze\\" + s + ".png");
        CopyOption[] options = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES
        };
        Files.copy(from, to, options);
    }
    public static void saveToFile(String s, Path p) throws IOException {
        Path from = p;
        Path to = Paths.get("C:\\Users\\Ucenik\\Downloads\\demo\\slike\\staze\\" + s + ".png");
        CopyOption[] options = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES
        };
        Files.copy(from, to, options);
    }
}