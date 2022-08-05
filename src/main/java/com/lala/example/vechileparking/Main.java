package com.lala.example.vechileparking;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 590, 400);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.resizableProperty().setValue(false);//resizable of
        stage.show();
        //
      new dbconnection();

    }

    public static void main(String[] args) {
        launch();
    }
}