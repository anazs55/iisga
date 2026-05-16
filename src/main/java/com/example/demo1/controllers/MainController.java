package com.example.demo1.controllers;


import com.example.demo1.controllers.Searchable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.Parent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class MainController {

    @FXML private VBox sidebar;
    @FXML private StackPane contentPane; // Le panneau de contenu principal de l'application
    @FXML private TextField searchField;
    private Searchable activeSearchableController;

    // Charge une vue FXML dans le panneau de contenu
    private void loadView(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent view = loader.load();
            contentPane.getChildren().setAll(view);
            Object controller = loader.getController();
            activeSearchableController = controller instanceof Searchable ? (Searchable) controller : null;
            performSearch(searchField != null ? searchField.getText() : "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        // Charger le tableau de bord par défaut au démarrage
        showAccueil();
        searchField.textProperty().addListener((obs, oldValue, newValue) -> performSearch(newValue));
    }

    @FXML private void handleSearch() {
        performSearch(searchField.getText());
    }

    private void performSearch(String query) {
        if (activeSearchableController != null) {
            activeSearchableController.search(query);
        }
    }

    @FXML private void showAccueil() { loadView("/com/example/demo1/views/dashbord.fxml"); }
    @FXML private void showFormateurs() { loadView("/com/example/demo1/views/formateurs.fxml"); }
    @FXML private void showSalles() { loadView("/com/example/demo1/views/Salles.fxml"); }
    @FXML private void showModules() { loadView("/com/example/demo1/views/modules.fxml"); }
    @FXML private void showGroupes() { loadView("/com/example/demo1/views/groupes.fxml"); }
    @FXML private void showEmplois() { loadView("/com/example/demo1/views/seances.fxml"); }
    @FXML private void showExamens() { loadView("/com/example/demo1/views/examens.fxml"); }

    @FXML private void toggleSidebar() {
        boolean visible = sidebar.isVisible();
        sidebar.setVisible(!visible);
        sidebar.setManaged(!visible);
    }

    @FXML private void showNotifications() {
        openDialog("/com/example/demo1/views/notifications.fxml", "Notifications");
    }

    @FXML private void showProfile() {
        openDialog("/com/example/demo1/views/profile.fxml", "Profil");
    }

    private void openDialog(String resourcePath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(resourcePath));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.initOwner(contentPane.getScene().getWindow());
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML private void handleLogout() {
        try {
            // Récupérer la fenêtre courante
            Stage stage = (Stage) contentPane.getScene().getWindow();
            
            // Charger la vue de connexion
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/demo1/views/login.fxml"));
            Parent loginView = fxmlLoader.load();
            
            // Afficher la nouvelle scène de connexion
            Scene loginScene = new Scene(loginView);
            stage.setScene(loginScene);
            stage.setTitle("Gestion Emplois du Temps - Connexion");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}