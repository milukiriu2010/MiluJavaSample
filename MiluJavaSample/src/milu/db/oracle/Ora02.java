package milu.db.oracle;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import milu.db.DriverShim;

// �I���N���ւ̐ڑ�
// jdbc:oracle:thin:@[�z�X�g��|IP�A�h���X]:1521/[SID|SERVICE_NAME]
public class Ora02 extends Application {
	// ���[�UID
	private TextField tfUSR = new TextField("milu");
	
	// �p�X���[�h
	private TextField tfPWD = new TextField("milu");
	
	// SID/SERVICE_NAME
	private TextField tfSID = new TextField("");
	
	// �z�X�g��/IP�A�h���X
	private TextField tfHOST = new TextField("");

	// �|�[�g�ԍ�
	private TextField tfPORT = new TextField("1521");
	
	// SQL����
	private TextArea taSQLI = new TextArea("select * from user_tables");

	// SQL����
	private TextArea taSQLO = new TextArea("");
	
	// ���s�{�^��
	private Button btnExec = new Button("���s");

	@Override
	public void start(Stage stage) throws Exception {
		Scene scene = new Scene(new Group(), 800, 600);

        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        // 
        grid.add(new Label("���[�UID: "), 0, 0);
        grid.add(this.tfUSR, 1, 0);
        // 
        grid.add(new Label("�p�X���[�h: "), 0, 1);
        grid.add(this.tfPWD, 1, 1);
        // 
        grid.add(new Label("SID/SERVICE_NAME: "), 0, 2);
        grid.add(this.tfSID, 1, 2);
        // 
        grid.add(new Label("�z�X�g��/IP�A�h���X: "), 0, 3);
        grid.add(this.tfHOST, 1, 3);
        // 
        grid.add(new Label("�|�[�g�ԍ�: "), 2, 3);
        grid.add(this.tfPORT, 3, 3);
        // SQL����͂���e�L�X�g�{�b�N�X
        grid.add(this.taSQLI, 0, 4, 6, 1);
        // SQL���ʂ��o�͂���e�L�X�g�{�b�N�X
        grid.add(this.taSQLO, 0, 5, 6, 1);
        // ���s�{�^��
        grid.add(btnExec, 0, 6, 4, 1);
        
        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
        
        
        btnExec.setOnAction((actionEvent) -> {
        	// SQL���ʂ��N���A����
        	this.taSQLO.clear();
        	// ���s�{�^������������ƁASQL�����s���A���ʂ�\������
        	execSQL();
        });
	}
	
	// ���s�{�^������������ƁASQL�����s���A���ʂ�\������
	private void execSQL() {
		try {
			URL url = new URL("file:loader/oracle/ojdbc8.jar");
			URL[] urls = { url };
			URLClassLoader loader =	new URLClassLoader( urls );
			Driver d = 
					(Driver)Class.forName
					(
						"oracle.jdbc.driver.OracleDriver", 
						true, 
						loader
					).getDeclaredConstructor().newInstance();
			DriverManager.registerDriver( new DriverShim(d) );

			// step2 create  the connection object
			System.out.println( "step2" );			
			// jdbc:oracle:thin:@[�z�X�g��|IP�A�h���X]:1521/[SID|SERVICE_NAME]
			Connection con = null;
			String urljdbc = 
					"jdbc:oracle:thin:@" + this.tfHOST.getText() + 
					":" + this.tfPORT.getText() +
					"/" + this.tfSID.getText();
			System.out.println( urljdbc );
			con = DriverManager.getConnection( urljdbc, this.tfUSR.getText(), this.tfPWD.getText() );
			
			// step3 create the statement object
			System.out.println( "step3" );
			Statement stmt=con.createStatement();
			
			//step4 execute query
			System.out.println( "step4" );
			String sql = this.taSQLI.getText().toString();
			System.out.println("SQL["+sql+"]");
			ResultSet rs=stmt.executeQuery(sql);
			// SQL�Ɋ܂܂��J���������擾���邽�߂Ɏg��
			ResultSetMetaData rsmd= rs.getMetaData();
			
			// �S���R�[�h���擾
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
			
			// �擾�������e�����ʂɏo��
			this.taSQLO.setText(sb.toString());
		} 
		catch ( Exception ex ) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			pw.flush();
			String str = sw.toString();
			
			// �擾�������e�����ʂɏo��
			this.taSQLO.setText(str);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}