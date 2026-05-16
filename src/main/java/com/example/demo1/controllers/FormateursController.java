package com.example.demo1.controllers;

import com.example.demo1.models.Formateur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class FormateursController implements Searchable {

    @FXML private TableView<Formateur> tableFormateurs;

    @FXML private TableColumn<Formateur, Integer> colId;
    @FXML private TableColumn<Formateur, String> colNom;
    @FXML private TableColumn<Formateur, String> colPrenom;
    @FXML private TableColumn<Formateur, String> colEmail;
    @FXML private TableColumn<Formateur, String> colTelephone;

    private ObservableList<Formateur> formateurs;
    private FilteredList<Formateur> filteredFormateurs;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTelephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        chargerDonnees();
    }

    @FXML
    private void handleAjouter() throws IOException {
        openDialog("/com/example/demo1/views/add_foramteur.fxml", "Nouveau formateur");
    }

    @FXML
    private void handleModifier() throws IOException {
        Formateur selected = tableFormateurs.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Veuillez sélectionner un formateur à modifier.", Alert.AlertType.WARNING);
            return;
        }
        openDialog("/com/example/demo1/views/add_foramteur.fxml", "Modifier le formateur");
    }

    @FXML
    private void handleSupprimer() {
        Formateur selected = tableFormateurs.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Veuillez sélectionner un formateur à supprimer.", Alert.AlertType.WARNING);
            return;
        }
        formateurs.remove(selected);
    }

    private void chargerDonnees() {
        if (formateurs == null) {
            formateurs = FXCollections.observableArrayList(
                new Formateur(1, "Diallo", "Amadou", "amadou@example.com", "770000001"),
                new Formateur(2, "Sow", "Awa", "awa@example.com", "770000002"),
                new Formateur(3, "Traoré", "Moussa", "moussa@example.com", "770000003")
            );
            filteredFormateurs = new FilteredList<>(formateurs, f -> true);
            tableFormateurs.setItems(filteredFormateurs);
        }
    }

    @Override
    public void search(String query) {
        String lowerQuery = query == null ? "" : query.toLowerCase().trim();
        filteredFormateurs.setPredicate(formateur -> {
            if (lowerQuery.isEmpty()) {
                return true;
            }
            return String.valueOf(formateur.getId()).contains(lowerQuery)
                || formateur.getNom().toLowerCase().contains(lowerQuery)
                || formateur.getPrenom().toLowerCase().contains(lowerQuery)
                || formateur.getEmail().toLowerCase().contains(lowerQuery)
                || formateur.getTelephone().toLowerCase().contains(lowerQuery);
        });
    }

    private void openDialog(String resourcePath, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resourcePath));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    private void showAlert(String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

