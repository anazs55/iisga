package com.example.demo1.controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.Parent;
import javafx.stage.Stage;
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

    @FXML
    public void initialize() {
        // Load dashboard by default when main layout opens
        showAccueil();
    }

    @FXML private void showAccueil() { loadView("/com/example/demo1/views/dashbord.fxml"); }
    @FXML private void showFormateurs() { loadView("/com/example/demo1/views/formateurs.fxml"); }
    @FXML private void showSalles() { loadView("/com/example/demo1/views/Salles.fxml"); }
    @FXML private void showModules() { loadView("/com/example/demo1/views/modules.fxml"); }
    @FXML private void showGroupes() { loadView("/com/example/demo1/views/groupes.fxml"); }
    @FXML private void showEmplois() { loadView("/com/example/demo1/views/seances.fxml"); }
    @FXML private void showExamens() { loadView("/com/example/demo1/views/examens.fxml"); }

    @FXML private void handleLogout() {
        try {
            // Get the current stage
            Stage stage = (Stage) contentPane.getScene().getWindow();
            
            // Load login view
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/demo1/views/login.fxml"));
            Parent loginView = fxmlLoader.load();
            
            // Set new scene
            Scene loginScene = new Scene(loginView);
            stage.setScene(loginScene);
            stage.setTitle("Gestion Emplois du Temps - Connexion");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}