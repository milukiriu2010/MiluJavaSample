package milu.fx.event;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

// マウス/キーイベントを検知するサンプル
public class Event01 extends Application {
	
	public static void main(String[] args) { launch( args ); }

	@Override
	public void start(Stage stage) throws Exception {
        // シーングラフの作成
        FlowPane    root    = new FlowPane();   
        Label       label   = new Label( "ボタンを押すorキーを入力" );
        Button      btn     = new Button( "push me" );
        TextField   tf      = new TextField("");
        root.getChildren().add( label );
        root.getChildren().add( btn );
        root.getChildren().add(tf);
                 
        // シーンの作成
        Scene   scene   = new Scene( root , 200 , 100 );
         
        /* アクションイベント、キーイベントの使い方を確認 */
        // ボタンに押下処理を追加する
        EventHandler<ActionEvent>      btnActionFilter = ( event ) -> { tf.setText( "button push!" ); System.out.println("button push!"); event.consume(); };
        btn.addEventHandler( ActionEvent.ANY , btnActionFilter );
         
        // シーンにキー入力処理を追加する
        EventHandler<KeyEvent>      sceneKeyFilter  = ( event ) -> { tf.setText( "key input(" + event.getText() + ")" ); System.out.println( "key input(" + event.getText() + ")" ); };
        scene.addEventFilter( KeyEvent.KEY_PRESSED , sceneKeyFilter );
         
         
        /* 以下、イベントの処理順を確認するためのフィルターとハンドラ */
        // ラベルにマウスクリック処理用のイベント・フィルターを設定
        EventHandler<MouseEvent>    btnClickFilter  = ( event ) -> System.out.println( "( Filter ) mouse click! " ); 
        label.addEventFilter( MouseEvent.MOUSE_PRESSED , btnClickFilter );
         
        // ラベルにマウスクリック処理用のイベント・ハンドラを設定
        EventHandler<MouseEvent>   btnHandler       = ( event ) -> System.out.println( "( Handler ) mouse click! " );
        label.addEventHandler( MouseEvent.MOUSE_PRESSED , btnHandler );
         
         
        // シーンにマウスクリック処理用のイベント・フィルターを設定
        EventHandler<MouseEvent>    sceneClickFilter= ( event ) -> System.out.println( "( Filter ) scene mouse click!" ); 
        scene.addEventFilter( MouseEvent.MOUSE_PRESSED , sceneClickFilter );
         
        // シーンにマウスクリック処理用のイベント・ハンドラを設定
        EventHandler<MouseEvent>   sceneHandler     = ( event ) -> System.out.println( "( Handler ) scene button click!" );
        scene.addEventHandler( MouseEvent.MOUSE_PRESSED , sceneHandler );
         
         
        // ステージにマウスクリック処理用のイベント・フィルターを設定
        EventHandler<MouseEvent>    stageClickFilter= ( event ) -> System.out.println( "( Filter ) stage mouse click!" ); 
        stage.addEventFilter( MouseEvent.MOUSE_PRESSED , stageClickFilter );
         
        // ステージにマウスクリック処理用のイベント・ハンドラを設定
        EventHandler<MouseEvent>   stageHandler     = ( event ) -> System.out.println( "( Handler ) stage button click!" );
        stage.addEventHandler( MouseEvent.MOUSE_PRESSED , stageHandler );
         
        // ウィンドウ表示
        stage.setScene( scene );
        stage.show();
	}

}
