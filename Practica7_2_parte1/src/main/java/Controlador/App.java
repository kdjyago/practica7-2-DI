package Controlador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("/Vista/calculator.fxml"));
        Pane rootPane = (Pane) loader.load();
        Scene scene = new Scene(rootPane, 300, 400);
        stage.setTitle("Practica7_2");
        stage.setScene(scene);
        stage.show();
    }
}