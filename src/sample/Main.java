package sample;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        Pane pane = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);

        primaryStage.setWidth(1024);
        primaryStage.setHeight(768);

        primaryStage.setTitle("Untitled - Notepad");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}