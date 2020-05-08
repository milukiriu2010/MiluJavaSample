package milu.fx.label;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// 編集不可/コピー可能なラベル
// https://stackoverflow.com/questions/22534067/copiable-label-textfield-labeledtext-in-javafx
public class Label01 extends Application {

    @Override
    public void start(Stage stage) {
    	// 編集不可/コピー可能なラベル
        TextField copyable = new TextField("Copy this");
        copyable.setEditable(false);
        copyable.getStyleClass().add("copyable-label");
        
        TextField tf2 = new TextField();
        
        // ブラウザ起動
        Label  lblUrl = new Label("https://docs.oracle.com/cd/B28359_01/java.111/b31224/urls.htm");
        lblUrl.setCursor( Cursor.HAND );
        lblUrl.getStyleClass().add("url");
        lblUrl.setOnMouseClicked( (event)->{
			getHostServices().showDocument( lblUrl.getText() );
		});
        
        VBox root = new VBox();
        root.getChildren().addAll(copyable, tf2, lblUrl );
        
        Scene scene = new Scene(root, 250, 150);
        scene.getStylesheets().add(getClass().getResource("/milu/fx/resources/Label01.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
