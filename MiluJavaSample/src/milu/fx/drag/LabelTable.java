package milu.fx.drag;

import java.util.List;
import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;

public class LabelTable extends Group {
	private Label  lblTable = new Label();
	
	private List<Label>  lblColumnLst = new ArrayList<>();
	
	private VBox   vBox = new VBox(2);
	
	public LabelTable( String tableName, List<String> colNameList )
	{
		super();
		
		this.vBox.getStyleClass().add("label_table");
		
		this.lblTable.setText( tableName );
		this.lblTable.getStyleClass().add("table_name");
		this.lblTable.prefWidth(-1);
		this.lblTable.prefWidth(-1);
		
		this.vBox.getChildren().add(this.lblTable);
		
		for ( String colName: colNameList )
		{
			Label lblColumn = new Label( colName );
			lblColumn.getStyleClass().add("column_w");
			this.lblColumnLst.add( lblColumn );
			this.vBox.getChildren().add(lblColumn);
		}
		
		this.getChildren().add( this.vBox );
	}
	
	public Bounds getTableBoundsInLocal()
	{
		Bounds b = this.lblTable.getBoundsInLocal();
		return b;
	}
	
	@SuppressWarnings({ "exports" })
	public List<Label> getColumnLabelLst()
	{
		return this.lblColumnLst;
	}
	
	@SuppressWarnings("exports")
	public Label getColumnLabel( String column )
	{
		Label lblColumn = null;
		for ( Label lbl : this.lblColumnLst )
		{
			if ( lbl.getText().equals( column ) )
			{
				lblColumn = lbl;
			}
		}
		return lblColumn;
	}
	
	public Point2D getTablePoint2D()
	{
		return new Point2D( this.lblTable.getWidth(), this.lblTable.getHeight() );
	}
}
