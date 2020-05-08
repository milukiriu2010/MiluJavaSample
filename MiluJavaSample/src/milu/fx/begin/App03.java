package milu.fx.begin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// --------------------------------------------------------------
// BorderPaneと複数子供の練習
// --------------------------------------------------------------
// https://www.tuyano.com/index3?id=9306003
// --------------------------------------------------------------
public class App03 extends Application {
    Label label;
    TextField field;
    Button button;
    
    public static void main(String[] args) {
        launch(args);
    }
    
	@Override
    public void start(Stage stage) throws Exception {
        label = new Label("This is JavaFX!");
        field = new TextField();
        button = new Button("Click");
        BorderPane pane = new BorderPane();
        pane.setTop(label);
        pane.setCenter(field);
        pane.setBottom(button);
        Scene scene = new Scene(pane, 320, 120);
        stage.setScene(scene);
        stage.show();
    }

}
