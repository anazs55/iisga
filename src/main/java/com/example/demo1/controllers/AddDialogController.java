package com.example.demo1.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class AddDialogController {

    @FXML private TextField txtNomModule;
    @FXML private TextField txtDuree;

    @FXML private TextField txtNomGroupe;
    @FXML private ComboBox<?> comboNiveau;
    @FXML private TextField txtEffectif;

    @FXML private TextField txtNomSalle;
    @FXML private TextField txtCapacite;
    @FXML private ComboBox<?> comboTypeSalle;

    @FXML private TextField txtNom;
    @FXML private TextField txtPrenom;
    @FXML private ComboBox<?> comboSpecialite;
    @FXML private TextField txtEmail;

    @FXML private RadioButton rbNormal;
    @FXML private RadioButton rbRattrapage;
    @FXML private ToggleGroup groupType;
    @FXML private ComboBox<?> comboModuleEx;
    @FXML private ComboBox<?> comboGroupeEx;
    @FXML private ComboBox<?> comboSalleEx;
    @FXML private DatePicker dateExamen;
    @FXML private TextField heureExamen;

    @FXML private ComboBox<?> comboModule;
    @FXML private ComboBox<?> comboFormateur;
    @FXML private ComboBox<?> comboGroupe;
    @FXML private ComboBox<?> comboSalle;
    @FXML private DatePicker datePicker;
    @FXML private TextField txtHeureDebut;
    @FXML private TextField txtHeureFin;

    @FXML
    private void handleCancel(ActionEvent event) {
        closeStage(event);
    }

    @FXML
    private void handleSave(ActionEvent event) {
        if (!validateFields()) {
            return;
        }
        closeStage(event);
    }

    private boolean validateFields() {
        if (txtNomModule != null) {
            if (isNullOrEmpty(txtNomModule.getText()) || isNullOrEmpty(txtDuree.getText())) {
                showAlert("Veuillez renseigner le nom du module et le volume horaire.", Alert.AlertType.WARNING);
                return false;
            }
            if (!isPositiveInteger(txtDuree.getText())) {
                showAlert("Le volume horaire doit être un nombre entier positif.", Alert.AlertType.WARNING);
                return false;
            }
        }

        if (txtNomGroupe != null) {
            if (isNullOrEmpty(txtNomGroupe.getText()) || comboNiveau.getSelectionModel().isEmpty() || isNullOrEmpty(txtEffectif.getText())) {
                showAlert("Veuillez renseigner le nom du groupe, le niveau et l'effectif.", Alert.AlertType.WARNING);
                return false;
            }
            if (!isPositiveInteger(txtEffectif.getText())) {
                showAlert("L'effectif doit être un nombre entier positif.", Alert.AlertType.WARNING);
                return false;
            }
        }

        if (txtNomSalle != null) {
            if (isNullOrEmpty(txtNomSalle.getText()) || isNullOrEmpty(txtCapacite.getText()) || comboTypeSalle.getSelectionModel().isEmpty()) {
                showAlert("Veuillez renseigner le nom, la capacité et le type de salle.", Alert.AlertType.WARNING);
                return false;
            }
            if (!isPositiveInteger(txtCapacite.getText())) {
                showAlert("La capacité doit être un nombre entier positif.", Alert.AlertType.WARNING);
                return false;
            }
        }

        if (txtNom != null) {
            if (isNullOrEmpty(txtNom.getText()) || isNullOrEmpty(txtPrenom.getText()) || comboSpecialite.getSelectionModel().isEmpty() || isNullOrEmpty(txtEmail.getText())) {
                showAlert("Veuillez renseigner le nom, le prénom, la spécialité et l'email du formateur.", Alert.AlertType.WARNING);
                return false;
            }
            if (!txtEmail.getText().contains("@")) {
                showAlert("Veuillez entrer une adresse email valide.", Alert.AlertType.WARNING);
                return false;
            }
        }

        if (comboModuleEx != null) {
            if (comboModuleEx.getSelectionModel().isEmpty() || comboGroupeEx.getSelectionModel().isEmpty() || comboSalleEx.getSelectionModel().isEmpty() || dateExamen.getValue() == null || isNullOrEmpty(heureExamen.getText())) {
                showAlert("Veuillez renseigner tous les champs de l'examen.", Alert.AlertType.WARNING);
                return false;
            }
            if (!isValidTime(heureExamen.getText())) {
                showAlert("L'heure de l'examen doit être au format HH:mm.", Alert.AlertType.WARNING);
                return false;
            }
        }

        if (comboModule != null) {
            if (comboModule.getSelectionModel().isEmpty() || comboFormateur.getSelectionModel().isEmpty() || comboGroupe.getSelectionModel().isEmpty() || comboSalle.getSelectionModel().isEmpty() || datePicker.getValue() == null || isNullOrEmpty(txtHeureDebut.getText()) || isNullOrEmpty(txtHeureFin.getText())) {
                showAlert("Veuillez renseigner tous les champs de la séance.", Alert.AlertType.WARNING);
                return false;
            }
            if (!isValidTime(txtHeureDebut.getText()) || !isValidTime(txtHeureFin.getText())) {
                showAlert("Les heures de début et de fin doivent être au format HH:mm.", Alert.AlertType.WARNING);
                return false;
            }
            if (!isEarlier(txtHeureDebut.getText(), txtHeureFin.getText())) {
                showAlert("L'heure de fin doit être postérieure à l'heure de début.", Alert.AlertType.WARNING);
                return false;
            }
        }

        return true;
    }

    private boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    private boolean isPositiveInteger(String value) {
        try {
            return Integer.parseInt(value.trim()) > 0;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private boolean isValidTime(String value) {
        if (isNullOrEmpty(value)) {
            return false;
        }
        String[] parts = value.trim().split(":");
        if (parts.length != 2) {
            return false;
        }
        try {
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);
            return hour >= 0 && hour < 24 && minute >= 0 && minute < 60;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private boolean isEarlier(String start, String end) {
        String[] startParts = start.trim().split(":");
        String[] endParts = end.trim().split(":");
        int startHour = Integer.parseInt(startParts[0]);
        int startMinute = Integer.parseInt(startParts[1]);
        int endHour = Integer.parseInt(endParts[0]);
        int endMinute = Integer.parseInt(endParts[1]);
        return endHour > startHour || (endHour == startHour && endMinute > startMinute);
    }

    private void showAlert(String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void closeStage(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
