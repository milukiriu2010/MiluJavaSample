package milu.fx.key;

import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import javafx.scene.layout.StackPane;
import javafx.scene.Scene;

// スペースを押すと、ボタンの文字が変わる
// https://stackoverflow.com/questions/31290928/how-to-set-accelerator-keyboard-shortcut-for-button-in-javafx
public class Key01 extends Application {
	
	boolean b = false;

	@Override
	public void start(Stage stage) throws Exception {
	    Button btn = new Button();
	    btn.setMnemonicParsing(true);
	    btn.setText("Hell_o");
	    btn.setOnAction(new EventHandler<ActionEvent>() {

	      @Override
	      public void handle(ActionEvent event) {
	        b = !b;
	        btn.setMnemonicParsing(false);
	        if (!b) {
	          btn.setText("Hell_o");
	          System.out.println("Hello");
	        } else {
	          btn.setText("W_orld");
	          System.out.println("World");
	        }
	        btn.setMnemonicParsing(true);
	      }
	    });

	    StackPane root = new StackPane();
	    root.getChildren().add(btn);

	    Scene scene = new Scene(root, 300, 250);

	    stage.setTitle("Hello World!");
	    stage.setScene(scene);
	    stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
