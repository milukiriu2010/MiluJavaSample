package milu.fx.begin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// --------------------------------------------------------------
// �`�F�b�N�{�b�N�X�̃C�x���g���K
// --------------------------------------------------------------
public class App06 extends Application {

    Label label;
    CheckBox check;
 
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) throws Exception {
        label = new Label("This is JavaFX!");
        check = new CheckBox("�`�F�b�N�{�b�N�X");
        check.setSelected(true);
        check.setOnAction((ActionEvent)->{
            label.setText(check.isSelected() ? 
                    "Selected!" : "not selected...");
        });
         
        BorderPane pane = new BorderPane();
        pane.setTop(label);
        pane.setCenter(check);
        Scene scene = new Scene(pane, 320, 120);
        stage.setScene(scene);
        stage.show();
    }

}
