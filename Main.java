package searchinfiles;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Петров Михаил Олегович
 * 31.07.18
 * Тестовое задание SPLAT
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        primaryStage.setTitle("Search in Files");
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }
}
