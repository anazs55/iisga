package com.example.demo1.controllers;

import com.example.demo1.models.Salle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    @FXML
    public void initialize() {
        // 1. Lier les colonnes aux attributs de ta classe Salle.java
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colCapacite.setCellValueFactory(new PropertyValueFactory<>("capacite"));

        // 2. Charger les données (Appel à la base de données)
        chargerDonnees();
    }

    @FXML
    private void handleAjouter() throws IOException {
        // Ouvre le Pop-up d'ajout
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddSalle.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.showAndWait();
        
        // Rafraîchir le tableau après la fermeture du pop-up
        chargerDonnees();
    }

    private void chargerDonnees() {
        // Ici, tu appelleras ton DAO pour récupérer la liste depuis SQL
        // tableSalles.setItems(salleDAO.getAllSalles());
    }
}