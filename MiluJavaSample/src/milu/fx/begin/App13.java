package milu.fx.begin;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// LoadExceptionが発生
// App13.fxml:18
// --------------------------------------------------------------
// FXML+CSS+JavaActionでGUIをデザイン
// --------------------------------------------------------------
// https://www.tuyano.com/index3?id=7346003&page=4
// --------------------------------------------------------------
public class App13 extends Application {
	
	public static void main(String[] args) { launch(args); }

	@Override
	public void start(Stage stage) throws Exception {
        BorderPane root;
        try {
            root = (BorderPane)FXMLLoader.load(getClass().getResource("/milu/fx/resources/App13.fxml"));
            Scene scene = new Scene(root,200,100);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
