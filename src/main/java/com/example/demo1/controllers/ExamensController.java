package com.example.demo1.controllers;

import com.example.demo1.models.Examen;
import com.example.demo1.models.Groupe;
import com.example.demo1.models.Module;
import com.example.demo1.models.Salle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.time.LocalDate;

public class ExamensController {

    @FXML private TableView<Examen> tableExamens;

    @FXML private TableColumn<Examen, String> colType;
    @FXML private TableColumn<Examen, Module> colModule;
    @FXML private TableColumn<Examen, Groupe> colGroupe;
    @FXML private TableColumn<Examen, Salle> colSalle;
    @FXML private TableColumn<Examen, LocalDate> colDate;
    @FXML private TableColumn<Examen, String> colHeure;

    @FXML
    public void initialize() {
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colModule.setCellValueFactory(new PropertyValueFactory<>("module"));
        colGroupe.setCellValueFactory(new PropertyValueFactory<>("groupe"));
        colSalle.setCellValueFactory(new PropertyValueFactory<>("salle"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colHeure.setCellValueFactory(new PropertyValueFactory<>("heure"));
        chargerDonnees();
    }

    private void chargerDonnees() {
        ObservableList<Examen> examens = FXCollections.observableArrayList(
            new Examen("Partiel", new Module(1, "Mathématiques", 30), new Groupe(1, "Groupe 1", "Licence 1"), new Salle(1, "Salle A101", 30), LocalDate.now().plusDays(7), "09:00"),
            new Examen("Final", new Module(2, "Physique", 25), new Groupe(2, "Groupe 2", "Licence 2"), new Salle(2, "Salle B202", 40), LocalDate.now().plusDays(14), "14:00")
        );
        tableExamens.setItems(examens);
    }

    @FXML
    private void handlePlanifier() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo1/views/add_examen.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Planifier un examen");
        stage.setScene(new Scene(root));
        stage.showAndWait();
        chargerDonnees();
    }

    @FXML
    private void handleDelete() {
        // TODO: delete selected examen.
    }
}

