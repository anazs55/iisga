package com.example.demo1.controllers;

import com.example.demo1.models.Salle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class SallesController {

    @FXML private TableView<Salle> tableSalles;
    @FXML private TableColumn<Salle, Integer> colId;
    @FXML private TableColumn<Salle, String> colNom;
    @FXML private TableColumn<Salle, Integer> colCapacite;

    private ObservableList<Salle> salles;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colCapacite.setCellValueFactory(new PropertyValueFactory<>("capacite"));
        chargerDonnees();
    }

    @FXML
    private void handleAjouter() throws IOException {
        openDialog("/com/example/demo1/views/add_salle.fxml", "Nouvelle salle");
    }

    @FXML
    private void handleModifier() throws IOException {
        Salle selected = tableSalles.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Veuillez sélectionner une salle à modifier.", Alert.AlertType.WARNING);
            return;
        }
        openDialog("/com/example/demo1/views/add_salle.fxml", "Modifier la salle");
    }

    @FXML
    private void handleSupprimer() {
        Salle selected = tableSalles.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Veuillez sélectionner une salle à supprimer.", Alert.AlertType.WARNING);
            return;
        }
        salles.remove(selected);
    }

    private void chargerDonnees() {
        if (salles == null) {
            salles = FXCollections.observableArrayList(
                new Salle(1, "Salle A101", 30),
                new Salle(2, "Salle B202", 40),
                new Salle(3, "Salle C303", 25)
            );
            tableSalles.setItems(salles);
        }
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