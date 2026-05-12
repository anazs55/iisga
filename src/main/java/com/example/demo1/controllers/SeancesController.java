package com.example.demo1.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class SeancesController {

    @FXML private TableView<?> tableSeances;

    @FXML private TableColumn<?, String> colFormateur;
    @FXML private TableColumn<?, String> colSalle;
    @FXML private TableColumn<?, String> colGroupe;
    @FXML private TableColumn<?, String> colModule;
    @FXML private TableColumn<?, LocalDate> colDate;
    @FXML private TableColumn<?, String> colDebut;
    @FXML private TableColumn<?, String> colFin;

    @FXML
    public void initialize() {
        if (colFormateur != null) colFormateur.setCellValueFactory(new PropertyValueFactory<>("formateur"));
        if (colSalle != null) colSalle.setCellValueFactory(new PropertyValueFactory<>("salle"));
        if (colGroupe != null) colGroupe.setCellValueFactory(new PropertyValueFactory<>("groupe"));
        if (colModule != null) colModule.setCellValueFactory(new PropertyValueFactory<>("module"));
        if (colDate != null) colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        if (colDebut != null) colDebut.setCellValueFactory(new PropertyValueFactory<>("debut"));
        if (colFin != null) colFin.setCellValueFactory(new PropertyValueFactory<>("fin"));

        chargerDonnees();
    }

    private void chargerDonnees() {
        // TODO: Wire to DAO/service.
    }

    @FXML
    private void handleAdd() {
        // TODO: open AddSeance.fxml dialog.
    }

    @FXML
    private void handleDelete() {
        // TODO: delete selected seance.
    }
}

