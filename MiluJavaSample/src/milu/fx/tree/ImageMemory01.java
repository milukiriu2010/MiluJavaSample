package milu.fx.tree;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ImageMemory01 extends Application {
	
    public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) 
	{
		TreeItem<String> rootItem = new TreeItem<String>( "root" );
		rootItem.setExpanded(true);
        for (int i = 1; i <= 100; i++) {
            ImageView iv = new ImageView( new Image("file:resources/images/madonna.png" ) );
            iv.setFitHeight( 16 );
            iv.setFitWidth( 16 );        	
        	
            TreeItem<String> item = new TreeItem<String>("Message" + i, iv );            
            rootItem.getChildren().add(item);
        }
        
        TreeView<String> tree = new TreeView<String> (rootItem);        
        StackPane root = new StackPane();
        root.getChildren().add(tree);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
        
        System.out.println( Runtime.getRuntime().maxMemory() );
        System.out.println( Runtime.getRuntime().totalMemory() );
        System.out.println( Runtime.getRuntime().freeMemory() );
        //2124414976
        //134217728
        //65172056
	}

}
