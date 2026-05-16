package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader =
                new FXMLLoader(getClass().getResource("/com/example/demo1/views/login.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        stage.getIcons().add(new Image(getClass().getResourceAsStream("/com/example/demo1/images/iisga.png")));
        stage.setTitle("Gestion Emplois du Temps");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}