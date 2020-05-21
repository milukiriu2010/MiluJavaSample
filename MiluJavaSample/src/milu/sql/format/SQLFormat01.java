package milu.sql.format;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// hibernate-core-5.3.1.Final.jarをライブラリパスに入れると
// Error occurred during initialization of boot layer
// java.lang.module.ResolutionException: Modules poi and poi.ooxml export package org.apache.poi.ss.extractor to module org.hibernate.orm.core
// が発生するのでコメントアウト
// import org.hibernate.engine.jdbc.internal.BasicFormatterImpl;

// ライブラリをコメントあうとしてるので、未動作
public class SQLFormat01 extends Application 
{
	private TextArea  taSQL    = new TextArea();
	private TextArea  taResult = new TextArea();
	private Button    btnFmt   = new Button("format");
	
	@Override
	public void start(Stage stage) throws Exception
	{
		HBox hBox = new HBox(2);
		hBox.getChildren().addAll( taSQL, btnFmt, taResult );
		
		Scene scene = new Scene( hBox, 640, 480 );
		stage.setScene(scene);
		stage.show();
		
		
		btnFmt.setOnAction
		(
			(event)->
			{
				// ライブラリをimportできないのでコメントアウト
				// String formatted = new BasicFormatterImpl().format( taSQL.getText() );
				// taResult.setText(formatted);
			}
		);
		
		taSQL.setText
		(
			"SELECT \n" + 
			"  u.first_name as fn, \n" + 
			"  u.last_name ln, \n" + 
			"  c.name cn, \n" + 
			"   ( select count(*) from a ) cnt \n" + 
			"FROM \n " + 
			"  user u join country c on u.uid = c.cid  join \n" +
			"  continent cn on c.cid = cn.cnid \n" +
			"WHERE \n" +
			"  u.uid >= 10000 and u.uid < 20000 \n" +
			"order by u.uid, u.firmst_name"
		);		
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
