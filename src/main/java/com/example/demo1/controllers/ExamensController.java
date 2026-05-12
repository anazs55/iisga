package com.example.demo1.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class ExamensController {

    @FXML private TableView<?> tableExamens;

    @FXML private TableColumn<?, String> colType;
    @FXML private TableColumn<?, String> colModule;
    @FXML private TableColumn<?, String> colGroupe;
    @FXML private TableColumn<?, String> colSalle;
    @FXML private TableColumn<?, LocalDate> colDate;
    @FXML private TableColumn<?, String> colHeure;

    @FXML
    public void initialize() {
        if (colType != null) colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        if (colModule != null) colModule.setCellValueFactory(new PropertyValueFactory<>("module"));
        if (colGroupe != null) colGroupe.setCellValueFactory(new PropertyValueFactory<>("groupe"));
        if (colSalle != null) colSalle.setCellValueFactory(new PropertyValueFactory<>("salle"));
        if (colDate != null) colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        if (colHeure != null) colHeure.setCellValueFactory(new PropertyValueFactory<>("heure"));

        chargerDonnees();
    }

    private void chargerDonnees() {
        // TODO: Wire to DAO/service.
    }

    @FXML
    private void handlePlanifier() {
        // TODO: open AddExamen.fxml dialog.
    }

    @FXML
    private void handleDelete() {
        // TODO: delete selected examen.
    }
}

