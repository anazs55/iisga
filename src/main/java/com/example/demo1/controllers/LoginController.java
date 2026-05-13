package com.example.demo1.controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label messageLabel;

    @FXML
    private void handleLogin() {
        String user = usernameField != null ? usernameField.getText() : null;
        String pass = passwordField != null ? passwordField.getText() : null;

        // TODO: Replace with real authentication (DAO/service)
        if ("admin".equals(user) && "123".equals(pass)) {
            // Navigate to main application
            try {
                // Get the current stage
                Stage stage = (Stage) usernameField.getScene().getWindow();
                
                // Load main layout
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/demo1/views/mainLayout.fxml"));
                Parent mainView = fxmlLoader.load();
                
                // Set new scene
                Scene mainScene = new Scene(mainView);
                stage.setScene(mainScene);
                stage.setTitle("Gestion Emplois du Temps - Tableau de Bord");
                
            } catch (IOException e) {
                e.printStackTrace();
                if (messageLabel != null) {
                    messageLabel.setText("Erreur lors du chargement de l'application");
                }
            }
        } else {
            if (messageLabel != null) {
                messageLabel.setText("Identifiants incorrects !");
            }
        }
    }
}

