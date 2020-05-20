package milu.fx.mouse;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

// Ctrl+ホイールマウスでズームイン/アウトする
public class Mouse01 extends Application {
	
	public static void main(String[] args){ launch(args); }

	@Override
	public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 350, 300);
        stage.setTitle("Dots");
        stage.setScene(scene);

        Circle circle = new Circle(175, 150, 10, Color.BLUE);
        addMouseScrolling(circle);
        root.getChildren().add(circle);

        stage.show();
	}

    public void addMouseScrolling(Node node) {
        node.setOnScroll((ScrollEvent event) -> {
            // Adjust the zoom factor as per your requirement
            double zoomFactor = 1.05;
            double deltaY = event.getDeltaY();
            if (deltaY < 0){
                zoomFactor = 2.0 - zoomFactor;
            }
            node.setScaleX(node.getScaleX() * zoomFactor);
            node.setScaleY(node.getScaleY() * zoomFactor);
        });
    }
}
