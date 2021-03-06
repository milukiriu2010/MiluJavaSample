package milu.fx.begin;


import java.io.IOException;
 
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// https://www.tuyano.com/index3?id=7346003&page=2
public class App14 extends Application {
     
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
            BorderPane root;
            try {
                root = (BorderPane)FXMLLoader.load(getClass().getResource("/milu/fx/resources/App14.fxml"));
                Scene scene = new Scene(root,200,100);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
