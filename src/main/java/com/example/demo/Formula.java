package com.example.demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sezona.Staza;
import tim.Tim;

import java.io.IOException;
import java.util.ArrayList;

public class Formula extends Application {
    public static String trenutnaStaza=null;
    private static Stage newStage;     // static field

    private static ArrayList<Staza> staze = new ArrayList<Staza>();
    private static ObservableList stazeNazivOL;

    private static ArrayList<Tim> timovi = new ArrayList<Tim>();
    private static ObservableList timoviNazivOL;

    @Override
    public void start(Stage stage) throws IOException {
        /*FXMLLoader fxmlLoader = new FXMLLoader(Formula.class.getResource("pocetnascena.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();*/

        Parent root = FXMLLoader.load(getClass().getResource("pocetnascena.fxml"));
        stage.setTitle("F1 - JavaFXML - Осма гимназија");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        Formula.newStage = stage;
        System.out.println("Stage F1 postavljen.");
    }
    public static void setStage(Stage newStage) { // set metod
        Formula.newStage = newStage;
        Formula.newStage.show();
    }

    public static Stage getStage() {             // get metod
        return Formula.newStage;
    }

    public static void main(String[] args) {
        launch();
    }

    // Staze
    public static ArrayList<Staza> getStaze(){
        return staze;
    }

    public static void setStaze(ArrayList<Staza> lista){
        staze = lista;
    }

    public static void setStazeNazivOL(ArrayList<String> nazivi) {
        if(stazeNazivOL == null){
            stazeNazivOL = FXCollections.observableList(nazivi);
        }
        else {
            stazeNazivOL.add(nazivi);
            stazeNazivOL = FXCollections.observableList(nazivi);
        }
    }

    public static ObservableList getStazeNazivOL() {
        return stazeNazivOL;
    }

    public static void dodajPojedinacno(String naziv) {
        stazeNazivOL.add(naziv);
    }

    public static void prikaziStazeAL() {
        staze.forEach((s) -> System.out.println(s));
    }

    // Timovi

    public static ArrayList<Tim> getTimovi(){
        return timovi;
    }

    public static void setTimovi(ArrayList<Tim> lista){
        timovi = lista;
    }

    public static void setTimoviNazivOL(ArrayList<String> nazivi) {
        if(timoviNazivOL == null){
            timoviNazivOL = FXCollections.observableList(nazivi);
        }
        else {
            timoviNazivOL.add(nazivi);
            timoviNazivOL = FXCollections.observableList(nazivi);
        }
    }

    public static ObservableList getTimoviNazivOL() {
        return timoviNazivOL;
    }


}