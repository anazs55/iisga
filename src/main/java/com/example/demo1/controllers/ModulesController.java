package com.example.demo1.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ModulesController {

    @FXML private TableView<?> tableModules;

    @FXML private TableColumn<?, Integer> colId;
    @FXML private TableColumn<?, String> colNom;
    @FXML private TableColumn<?, Integer> colDuree;

    @FXML
    public void initialize() {
        if (colId != null) colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        if (colNom != null) colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        if (colDuree != null) colDuree.setCellValueFactory(new PropertyValueFactory<>("duree"));

        chargerDonnees();
    }

    private void chargerDonnees() {
        // TODO: Wire to DAO/service.
    }
}

