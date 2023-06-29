package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FormulaController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private ImageView bgi;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void initialize(URL url, ResourceBundle rb) {

        bgi.setImage(new Image("C:\\Users\\Ucenik\\Downloads\\demo\\slike\\f1_logo.png"));
        System.out.println("bg slika je stavljena");
    }

    @FXML
    private void scenaStaze() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("stazePrikaz.fxml"));
        Scene scene = new Scene(root);

        Formula.getStage().setScene(scene);
        Formula.setStage(Formula.getStage());

        //   scene.getStylesheets().add(f1FXML.class.getResource("F1.css").toExternalForm());

        System.out.println("Scena Staze postavljena.");
    }

    @FXML
    private void scenaTimovi() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("timoviPrikaz.fxml"));
        Scene scene = new Scene(root);

        Formula.getStage().setScene(scene);
        Formula.setStage(Formula.getStage());

        //   scene.getStylesheets().add(f1FXML.class.getResource("F1.css").toExternalForm());

        System.out.println("Scena Timovi postavljena.");
    }

}
