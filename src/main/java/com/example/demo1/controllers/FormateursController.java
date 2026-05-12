package com.example.demo1.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FormateursController {

    @FXML private TableView<?> tableFormateurs;

    @FXML private TableColumn<?, Integer> colId;
    @FXML private TableColumn<?, String> colNom;
    @FXML private TableColumn<?, String> colPrenom;
    @FXML private TableColumn<?, String> colEmail;
    @FXML private TableColumn<?, String> colTelephone;

    @FXML
    public void initialize() {
        if (colId != null) colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        if (colNom != null) colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        if (colPrenom != null) colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        if (colEmail != null) colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        if (colTelephone != null) colTelephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));

        chargerDonnees();
    }

    private void chargerDonnees() {
        // TODO: Wire to DAO/service.
    }
}

