package com.example.demo1.controllers;

import com.example.demo1.models.Groupe;
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

public class GroupesController {

    @FXML private TableView<Groupe> tableGroupes;

    @FXML private TableColumn<Groupe, Integer> colId;
    @FXML private TableColumn<Groupe, String> colNom;
    @FXML private TableColumn<Groupe, String> colNiveau;

    private ObservableList<Groupe> groupes;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colNiveau.setCellValueFactory(new PropertyValueFactory<>("niveau"));
        chargerDonnees();
    }

    @FXML
    private void handleAjouter() throws IOException {
        openDialog("/com/example/demo1/views/add_groupe.fxml", "Nouveau groupe");
    }

    @FXML
    private void handleModifier() throws IOException {
        Groupe selected = tableGroupes.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Veuillez sélectionner un groupe à modifier.", Alert.AlertType.WARNING);
            return;
        }
        openDialog("/com/example/demo1/views/add_groupe.fxml", "Modifier le groupe");
    }

    @FXML
    private void handleSupprimer() {
        Groupe selected = tableGroupes.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Veuillez sélectionner un groupe à supprimer.", Alert.AlertType.WARNING);
            return;
        }
        groupes.remove(selected);
    }

    private void chargerDonnees() {
        if (groupes == null) {
            groupes = FXCollections.observableArrayList(
                new Groupe(1, "Groupe 1", "Licence 1"),
                new Groupe(2, "Groupe 2", "Licence 2"),
                new Groupe(3, "Groupe 3", "Master 1")
            );
            tableGroupes.setItems(groupes);
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

