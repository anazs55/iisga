package com.example.demo1.controllers;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
            // TODO: load Main.fxml/MainLayout
            if (messageLabel != null) messageLabel.setText("");
        } else {
            if (messageLabel != null) messageLabel.setText("Identifiants incorrects !");
        }
    }
}

