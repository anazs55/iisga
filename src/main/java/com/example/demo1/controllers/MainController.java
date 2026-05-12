package com.example.demo1.controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import javafx.scene.Parent;
import java.io.IOException;

public class MainController {

    @FXML private StackPane contentPane; // Le centre de ton Main.fxml

    // Méthode générique pour changer de page
    private void loadView(String fxmlFile) {
        try {
            Parent view = FXMLLoader.load(getClass().getResource(fxmlFile));
            contentPane.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML private void showFormateurs() { loadView("Formateurs.fxml"); }
    @FXML private void showSalles() { loadView("Salles.fxml"); }
    @FXML private void showGroupes() { loadView("Groupes.fxml"); }
    @FXML private void showSeances() { loadView("Seances.fxml"); }
}