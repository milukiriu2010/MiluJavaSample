package milu.fx.line;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;

// (0,0)からクリックした地点まで矢印を描く
// https://stackoverflow.com/questions/41353685/how-to-draw-arrow-javafx-pane
public class Arrow01 extends Application {
	
	public static void main(String[] args){ launch(args); }

	@Override
	public void start(Stage stage) throws Exception {
	    Pane root = new Pane();
	    Arrow arrow = new Arrow();
	    root.getChildren().add(arrow);

	    root.setOnMouseClicked(evt -> {
	        switch (evt.getButton()) {
	            case PRIMARY:
	                // set pos of end with arrow head
	                arrow.setEndX(evt.getX());
	                arrow.setEndY(evt.getY());
	                break;
	            case SECONDARY:
	                // set pos of end without arrow head
	                arrow.setStartX(evt.getX());
	                arrow.setStartY(evt.getY());
	                break;
	            default:
	            	break;
	        }
	    });

	    Scene scene = new Scene(root, 400, 400);

	    stage.setScene(scene);
	    stage.show();
	}

}
