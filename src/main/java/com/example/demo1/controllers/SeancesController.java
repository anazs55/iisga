package com.example.demo1.controllers;

import com.example.demo1.models.Formateur;
import com.example.demo1.models.Groupe;
import com.example.demo1.models.Module;
import com.example.demo1.models.Salle;
import com.example.demo1.models.Seance;
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

public class SeancesController {

    @FXML private TableView<Seance> tableSeances;

    @FXML private TableColumn<Seance, Formateur> colFormateur;
    @FXML private TableColumn<Seance, Salle> colSalle;
    @FXML private TableColumn<Seance, Groupe> colGroupe;
    @FXML private TableColumn<Seance, Module> colModule;
    @FXML private TableColumn<Seance, LocalDate> colDate;
    @FXML private TableColumn<Seance, String> colDebut;
    @FXML private TableColumn<Seance, String> colFin;

    @FXML
    public void initialize() {
        colFormateur.setCellValueFactory(new PropertyValueFactory<>("formateur"));
        colSalle.setCellValueFactory(new PropertyValueFactory<>("salle"));
        colGroupe.setCellValueFactory(new PropertyValueFactory<>("groupe"));
        colModule.setCellValueFactory(new PropertyValueFactory<>("module"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colDebut.setCellValueFactory(new PropertyValueFactory<>("debut"));
        colFin.setCellValueFactory(new PropertyValueFactory<>("fin"));
        chargerDonnees();
    }

    private void chargerDonnees() {
        ObservableList<Seance> seances = FXCollections.observableArrayList(
            new Seance(new Formateur(1, "Diallo", "Amadou", "amadou@example.com", "770000001"),
                       new Salle(1, "Salle A101", 30),
                       new Groupe(1, "Groupe 1", "Licence 1"),
                       new Module(1, "Mathématiques", 30),
                       LocalDate.now(), "08:30", "10:00"),
            new Seance(new Formateur(2, "Sow", "Awa", "awa@example.com", "770000002"),
                       new Salle(2, "Salle B202", 40),
                       new Groupe(2, "Groupe 2", "Licence 2"),
                       new Module(2, "Physique", 25),
                       LocalDate.now().plusDays(1), "10:30", "12:00")
        );
        tableSeances.setItems(seances);
    }

    @FXML
    private void handleAdd() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo1/views/add_seance.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Nouvelle séance");
        stage.setScene(new Scene(root));
        stage.showAndWait();
        chargerDonnees();
    }

    @FXML
    private void handleDelete() {
        // TODO: delete selected seance.
    }
}

