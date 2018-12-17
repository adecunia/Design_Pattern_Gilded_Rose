package edu.insightr.gildedrose;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/Graphic Interface.fxml"));
            Scene scene = new Scene(root, 1200, 800);
            primaryStage.setScene(scene);

            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}