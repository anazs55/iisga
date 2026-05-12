package com.example.demo1.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class GroupesController {

    @FXML private TableView<?> tableGroupes;

    @FXML private TableColumn<?, Integer> colId;
    @FXML private TableColumn<?, String> colNom;
    @FXML private TableColumn<?, String> colNiveau;

    @FXML
    public void initialize() {
        if (colId != null) colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        if (colNom != null) colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        if (colNiveau != null) colNiveau.setCellValueFactory(new PropertyValueFactory<>("niveau"));

        chargerDonnees();
    }

    private void chargerDonnees() {
        // TODO: Wire to DAO/service.
    }
}

