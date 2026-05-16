package com.example.demo1.controllers;

import com.example.demo1.models.Module;
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

public class ModulesController implements Searchable {

    @FXML private TableView<Module> tableModules;

    @FXML private TableColumn<Module, Integer> colId;
    @FXML private TableColumn<Module, String> colNom;
    @FXML private TableColumn<Module, Integer> colDuree;

    private ObservableList<Module> modules;
    private FilteredList<Module> filteredModules;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colDuree.setCellValueFactory(new PropertyValueFactory<>("duree"));
        chargerDonnees();
    }

    @FXML
    private void handleAjouter() throws IOException {
        openDialog("/com/example/demo1/views/add_module.fxml", "Nouveau module");
    }

    @FXML
    private void handleModifier() throws IOException {
        Module selected = tableModules.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Veuillez sélectionner un module à modifier.", Alert.AlertType.WARNING);
            return;
        }
        openDialog("/com/example/demo1/views/add_module.fxml", "Modifier le module");
    }

    @FXML
    private void handleSupprimer() {
        Module selected = tableModules.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Veuillez sélectionner un module à supprimer.", Alert.AlertType.WARNING);
            return;
        }
        modules.remove(selected);
    }

    private void chargerDonnees() {
        if (modules == null) {
            modules = FXCollections.observableArrayList(
                new Module(1, "Mathématiques", 30),
                new Module(2, "Physique", 25),
                new Module(3, "Informatique", 40)
            );
            filteredModules = new FilteredList<>(modules, p -> true);
            tableModules.setItems(filteredModules);
        }
    }

    @Override
    public void search(String query) {
        if (filteredModules == null) {
            return;
        }
        String lowerQuery = query == null ? "" : query.toLowerCase();
        filteredModules.setPredicate(module ->
            lowerQuery.isEmpty()
                || String.valueOf(module.getId()).contains(lowerQuery)
                || module.getNom().toLowerCase().contains(lowerQuery)
                || String.valueOf(module.getDuree()).contains(lowerQuery)
        );
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

