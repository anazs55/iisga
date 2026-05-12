package com.example.demo1.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML private Label salleCount;
    @FXML private Label profCount;
    @FXML private Label groupeCount;

    @FXML
    public void initialize() {
        if (salleCount != null) salleCount.setText("0");
        if (profCount != null) profCount.setText("0");
        if (groupeCount != null) groupeCount.setText("0");
    }
}

