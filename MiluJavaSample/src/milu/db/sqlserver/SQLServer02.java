package milu.db.sqlserver;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import milu.db.DriverShim;

// SQLServerへの接続
// 通常認証
// jdbc:sqlserver://[ホスト名|IPアドレス]:1433;databaseName=[DB名];
// AD認証
// jdbc:sqlserver://[ホスト名|IPアドレス]:1433;databaseName=[DB名];integratedSecurity=true;
// AD認証するためには、c:\Windows\System32にsqljdbc_auth.dllを配置する
public class SQLServer02 extends Application {
	// ユーザID
	private TextField tfUSR = new TextField("milux");
	
	// パスワード
	private TextField tfPWD = new TextField("milux");
	
	// AD認証
	private CheckBox cbAD = new CheckBox("AD認証");
	
	// DB名
	private TextField tfSID = new TextField("miludb");
	
	// ホスト名/IPアドレス
	private TextField tfHOST = new TextField("localhost");

	// ポート番号
	private TextField tfPORT = new TextField("1433");
	
	// SQL入力
	private TextArea taSQLI = new TextArea("select * from sys.objects");

	// SQL結果
	private TextArea taSQLO = new TextArea("");
	
	// 実行ボタン
	private Button btnExec = new Button("実行");

	@Override
	public void start(Stage stage) throws Exception {
		Scene scene = new Scene(new Group(), 800, 600);

        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        // 
        grid.add(new Label("ユーザID: "), 0, 0);
        grid.add(this.tfUSR, 1, 0);
        //
        grid.add(this.cbAD, 2, 0);
        // 
        grid.add(new Label("パスワード: "), 0, 1);
        grid.add(this.tfPWD, 1, 1);
        // 
        grid.add(new Label("DB名: "), 0, 2);
        grid.add(this.tfSID, 1, 2);
        // 
        grid.add(new Label("ホスト名/IPアドレス: "), 0, 3);
        grid.add(this.tfHOST, 1, 3);
        // 
        grid.add(new Label("ポート番号: "), 2, 3);
        grid.add(this.tfPORT, 3, 3);
        // 実行ボタン
        grid.add(btnExec, 0, 4, 4, 1);
        
        VBox vbox = new VBox();
        // 接続先DB情報
        vbox.getChildren().add(grid);
        // SQLを入力するテキストボックス
        this.taSQLI.setPrefWidth(600);
        vbox.getChildren().add(this.taSQLI);
        // SQL結果を出力するテキストボックス
        this.taSQLO.setPrefWidth(600);
        vbox.getChildren().add(this.taSQLO);
        
        Group root = (Group)scene.getRoot();
        root.getChildren().add(vbox);
        stage.setScene(scene);
        stage.show();
        
        
        btnExec.setOnAction((actionEvent) -> {
        	// SQL結果をクリアする
        	this.taSQLO.clear();
        	// 実行ボタンを押下すると、SQLを実行し、結果を表示する
        	execSQL();
        });
        
        // AD認証ON ⇒ユーザID/パスワード入力不可
        // AD認証OFF⇒ユーザID/パスワード入力可
        cbAD.selectedProperty().addListener((obs,oldVal,newVal) -> {
        	this.tfUSR.setEditable(!newVal);
        	this.tfPWD.setEditable(!newVal);
        });
	}
	
	// 実行ボタンを押下すると、SQLを実行し、結果を表示する
	private void execSQL() {
		try {
			URL url = new URL("file:loader/sqlserver/mssql-jdbc-6.4.0.jre9.jar");
			URL[] urls = { url };
			URLClassLoader loader =	new URLClassLoader( urls );
			Driver d = 
					(Driver)Class.forName
					(
						"com.microsoft.sqlserver.jdbc.SQLServerDriver", 
						true, 
						loader
					).getDeclaredConstructor().newInstance();
			DriverManager.registerDriver( new DriverShim(d) );

			// step2 create  the connection object
			System.out.println( "step2" );			
			// 通常認証
			// jdbc:sqlserver://[ホスト名|IPアドレス]:1433;databaseName=[DB名];
			// AD認証
			// jdbc:sqlserver://[ホスト名|IPアドレス]:1433;databaseName=[DB名];integratedSecurity=true;
			Connection con = null;
			
			// 通常認証
			if ( cbAD.isSelected() == false ) {
				String urljdbc = 
						"jdbc:sqlserver://" + this.tfHOST.getText() + 
						":" + this.tfPORT.getText() +
						";databaseName=" + this.tfSID.getText() + ";";
				System.out.println( urljdbc );
				con = DriverManager.getConnection( urljdbc, this.tfUSR.getText(), this.tfPWD.getText() );				
			}
			// AD認証
			else {
				String urljdbc = 
						"jdbc:sqlserver://" + this.tfHOST.getText() + 
						":" + this.tfPORT.getText() +
						";databaseName=" + this.tfSID.getText() + ";integratedSecurity=true;";
				System.out.println( urljdbc );
				con = DriverManager.getConnection( urljdbc );				
			}
			
			// step3 create the statement object
			System.out.println( "step3" );
			Statement stmt=con.createStatement();
			
			//step4 execute query
			System.out.println( "step4" );
			String sql = this.taSQLI.getText().toString();
			System.out.println("SQL["+sql+"]");
			ResultSet rs=stmt.executeQuery(sql);
			// SQLに含まれるカラム数を取得するために使う
			ResultSetMetaData rsmd= rs.getMetaData();
			
			// 全レコードを取得
			StringBuffer sb = new StringBuffer();
			while(rs.next()) {
				for (int i=1; i<=rsmd.getColumnCount();i++) {
					sb.append(rs.getString(i));
					sb.append("\t");
				}
				sb.append("\n");
			}
			  
			//step5 close the connection object
			System.out.println( "step5" );
			con.close();
			
			// 取得した内容を結果に出力
			this.taSQLO.setText(sb.toString());
		} 
		catch ( Exception ex ) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			pw.flush();
			String str = sw.toString();
			
			// 取得した内容を結果に出力
			this.taSQLO.setText(str);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
