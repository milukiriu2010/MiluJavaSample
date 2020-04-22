package milu.fx.begin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// --------------------------------------------------------------
// BorderPane�̗��K
// --------------------------------------------------------------
// https://www.tuyano.com/index3?id=12466003&page=3
// --------------------------------------------------------------
// Java14�ŃG���[
// https://stackoverflow.com/questions/53035454/javafx-module-javafx-graphics
// module-info.java�Ɉȉ����L�q�ŉ���
// 	 exports milu.fx.begin;
//   opens milu.fx.begin to javafx.graphics;
//--------------------------------------------------------------
public class App01 extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
        Label label = new Label("This is JavaFX!");
        BorderPane pane = new BorderPane();
        pane.setCenter(label);
        Scene scene = new Scene(pane, 320, 240);
        stage.setScene(scene);
        stage.show();
    }

}
