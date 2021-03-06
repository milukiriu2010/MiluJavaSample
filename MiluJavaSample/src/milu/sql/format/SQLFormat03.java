package milu.sql.format;

import java.io.PrintWriter;
import java.io.StringWriter;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.util.deparser.ExpressionDeParser;
import net.sf.jsqlparser.util.deparser.SelectDeParser;
//import sql.parse.visitor.ExampleStatementVisitor;

// 複数行のSQLを1行に整形する
public class SQLFormat03 extends Application 
{
	private TextArea  taSQL    = new TextArea();
	private TextArea  taResult = new TextArea();
	private Button    btnFmt   = new Button("format");
	
	@Override
	public void start(Stage stage) throws Exception
	{
		HBox hBox = new HBox(2);
		hBox.getChildren().addAll( taSQL, btnFmt );
		
		SplitPane sp = new SplitPane();
		sp.setOrientation( Orientation.HORIZONTAL );
		sp.getItems().addAll( hBox, taResult );
		sp.setDividerPositions( 0.5f, 0.5f );
		
		Scene scene = new Scene( sp, 640, 480 );
		stage.setScene(scene);
		stage.show();
		
		
		btnFmt.setOnAction
		(
			(event)->
			{
				this.format();
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
	
	private void format()
	{
		StringBuffer sb = new StringBuffer();
		try
		{
			String sqlStr = this.taSQL.getText();
			Statement stmt = CCJSqlParserUtil.parse(sqlStr);
			this.analyze(stmt, sb);
		}
		catch ( JSQLParserException jsqlEx )
		{
			//jsqlEx.printStackTrace();
			StringWriter sw = new StringWriter();
			PrintWriter  pw = new PrintWriter(sw);
			jsqlEx.printStackTrace(pw);
			sb.append( "=== JSQLParserException =============\n" );
			sb.append( sw.toString() );
		}
		finally
		{
			this.taResult.setText( sb.toString() );
		}
	}
	
	private void analyze( Statement stmt, StringBuffer sb )
	{
		Example2StatementVisitor statementVisitor = new Example2StatementVisitor();
		stmt.accept(statementVisitor);
		
		String sqlType = statementVisitor.getSqlType();
		sb.append("<<" + sqlType + ">>\n" );
		
		if ( "SELECT".equals(sqlType) )
		{
			Select select = (Select)stmt;
			StringBuilder buffer = new StringBuilder();
			ExpressionDeParser expressionDeParser = new Example2ExpressionDeParser();
			/*
			ExpressionDeParser expressionDeParser = new ExpressionDeParser()
			{
				@Override
				public void visit( Column tableColumn )
				{
					System.out.println( "Column:" + tableColumn );
					this.getBuffer().append( "\t\n" + tableColumn );					
				}
		
			};
			*/
			SelectDeParser deparser = new SelectDeParser(expressionDeParser, buffer);
			expressionDeParser.setSelectVisitor(deparser);
			expressionDeParser.setBuffer(buffer);
			select.getSelectBody().accept(deparser);
			sb.append( buffer.toString() );
		}
	}	
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
