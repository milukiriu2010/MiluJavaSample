package milu.fx.task;

import javafx.application.Application;
import javafx.stage.Stage;

import javafx.application.Platform;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.geometry.*;
import javafx.scene.image.*;
import javafx.animation.*;
import javafx.util.*;
import javafx.event.*;

//import java.beans.*;

import java.util.concurrent.*;

// http://itpro.nikkeibp.co.jp/article/COLUMN/20130828/500602/
public class LongTermTask04 extends Application {
	
	// スレッドプール
    private ExecutorService service = Executors.newSingleThreadExecutor();
    
    Future<String>  future = null;

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10.0));
        
        Button btnCancel = new Button("CANCEL");
        btnCancel.setOnAction(
        	event->
        	{
        		future.cancel( true );
        		System.out.println( "www" );
        	}
        );

        HBox hBox = new HBox( 2 );
        hBox.getChildren().addAll( initButton(), btnCancel );
        root.setTop( hBox );

        // イメージを回転させるアニメーション
        // https://stackoverflow.com/questions/16990482/java-lang-illegalargumentexception-invalid-url-or-resource-not-found
        ImageView image = new ImageView(new Image("file:resources/images/duke.png"));
        RotateTransition transition = new RotateTransition(Duration.millis(2_000), image);
        transition.setToAngle(360);
        transition.setInterpolator(Interpolator.LINEAR);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.play();
        root.setCenter(image);

        Scene scene = new Scene(root, 500, 500);
 
        stage.setTitle("Long Time Task Demo");
        stage.setScene(scene);
        stage.show();
    }

    private Button initButton() {
        // 長い時間のかかるタスクを実行するボタン
        Button button = new Button("Long Term Task");

        button.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                // ボタンを使用できないようにする
                button.setDisable(true);
                
                // 非同期にタスクを実行
                Callable<String> task = new Callable<String>() {
                    @Override
                    public String call() {
                    	System.out.println( "start." );
                        // 長い時間のかかる処理
                        longExecution();
                        
                        // JavaFX Application Threadへのアクセス
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                // ボタンを使用可能に戻す
                                button.setDisable(false);
                            }
                        });      
                        return "owata.";
                    }
                };
                future = service.submit(task);
            }
        });
        
        return button;
    }
    
    // 長い時間のかかる処理
    private void longExecution() {
        try {
            Thread.sleep(10_000);
            System.out.println( "finished." );
        } 
        catch (InterruptedException ex)
        {
        	System.out.println( "interrupted." );
        }
    }

    public static void main(String... args) {
        launch(args);
    }
}

