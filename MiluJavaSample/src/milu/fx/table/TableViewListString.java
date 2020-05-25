package milu.fx.table;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.ContextMenu;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.stage.Stage;

// レコード追加
// ただし、文字列型のみ
public class TableViewListString extends Application 
{
	private TableView<List<String>>  tableView = new TableView<>();
	private List<String>       headLst = Arrays.asList( "-", "First Name", "Last Name", "Email" );
	private List<List<String>> dataLst = new ArrayList<>();
	private ObservableList<List<String>> obsDataLst = null;
	
	private List<Integer>  selectedRowLst = new ArrayList<>();
	
	final HBox hb = new HBox();
	
    public static void main(String[] args) 
    {
        launch(args);
    }
    
	@Override
	public void start(Stage stage) 
	{
		this.initData();
		
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(450);
        stage.setHeight(500);
 
        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20));
        
        this.tableView.setPrefWidth(300);
        this.tableView.setPrefHeight(200);
        this.tableView.getSelectionModel().setSelectionMode( SelectionMode.MULTIPLE );
        this.tableView.getSelectionModel().setCellSelectionEnabled( true );
        this.tableView.setRowFactory(null);
        
        this.setTableColumnWithData();
        this.setContextMenu();
        
        final TextField addFirstName = new TextField();
        addFirstName.setPromptText("First Name");
        addFirstName.setMaxWidth(100);
        final TextField addLastName = new TextField();
        addLastName.setMaxWidth(100);
        addLastName.setPromptText("Last Name");
        final TextField addEmail = new TextField();
        addEmail.setMaxWidth(100);
        addEmail.setPromptText("Email");        
        
        final Button addButton = new Button("Add");
        addButton.setOnAction
        (
        	(event)->
        	{
        		List<String> dataRow = new ArrayList<>();
        		dataRow.add( String.valueOf(this.dataLst.size()+1) );
        		dataRow.add( addFirstName.getText() );
        		dataRow.add( addLastName.getText() );
        		dataRow.add( addEmail.getText() );
        		//this.dataLst.add(dataRow);
        		this.obsDataLst.add(dataRow);
        		
                addFirstName.clear();
                addLastName.clear();
                addEmail.clear();        		
        	}
        );
        
        this.hb.getChildren().addAll(addFirstName, addLastName, addEmail, addButton);
        this.hb.setSpacing(3);        
        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, this.tableView, this.hb);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);        
        
        
        stage.setScene(scene);
        stage.show();
	}
	
	private void initData()
	{
		List<String> dataRow1 = Arrays.asList("1","Michael","Brown","michael.brown@example.com");
		List<String> dataRow2 = Arrays.asList("2","Jacob","Smith","jacob.smith@example.com");
		List<String> dataRow3 = Arrays.asList("3","Isabella","Johnson","isabella.johnson@example.com");
		List<String> dataRow4 = Arrays.asList("4","Ethan","Williams","ethan.williams@example.com");
		List<String> dataRow5 = Arrays.asList("5","Emma","Jones","emma.jones@example.com");
		
		this.dataLst.add(dataRow1);
		this.dataLst.add(dataRow2);
		this.dataLst.add(dataRow3);
		this.dataLst.add(dataRow4);
		this.dataLst.add(dataRow5);
		
		this.obsDataLst = FXCollections.observableArrayList(this.dataLst);
	}

	private void setTableColumnWithData()
	{
		for ( int i = 0; i < this.headLst.size(); i++ )
		{
			String head = this.headLst.get(i);
			TableColumn<List<String>,String> tableCol = new TableColumn<List<String>,String>(head);
			/*
			Image image = new Image("file:resources/images/madonna.png" );
	        ImageView iv = new ImageView( image );
	        iv.setFitHeight( 32 );
	        iv.setFitWidth( 32 );
			iv.addEventFilter
			(
				MouseEvent.MOUSE_CLICKED,
				(event)->
				{
					System.out.println("ImageView.clicked:"+head);
					this.tableView.getSelectionModel().selectRange
					(
						0,
						tableCol,
						this.obsDataLst.size()-1,
						tableCol
					);
					event.consume();
				}
			);
			//tableCol.setGraphic(iv);
			*/
			
			Label label = new Label("💛");
			label.setOnMouseClicked
			(
				(event)->
				{
					System.out.println("Label.clicked:"+head);
					TableView.TableViewSelectionModel<List<String>>  selectionModel = this.tableView.getSelectionModel(); 
					boolean isSelectedAll = true;
					for ( int ii = 0; ii < this.obsDataLst.size(); ii++ )
					{
						if ( selectionModel.isSelected(ii,tableCol) == false )
						{
							isSelectedAll = false;
						}
					}
					
					if ( isSelectedAll == true )
					{
						for ( int ii = 0; ii < this.obsDataLst.size(); ii++ )
						{
							selectionModel.clearSelection( ii, tableCol );
						}
					}
					else
					{
						selectionModel.selectRange
						(
							0,
							tableCol,
							this.obsDataLst.size()-1,
							tableCol
						);
					}
				}
			);
			tableCol.setGraphic(label);
			
			tableCol.setSortable(false);
			this.setContextMenu(tableCol);
			
			final int index = i;
			tableCol.setCellValueFactory
			(
				(p)->
				{
					List<String> x = p.getValue();
					if ( x != null )
					{
						return new SimpleStringProperty( x.get( index ) );
					}
					else
					{
						return new SimpleStringProperty( "<NULL>" );
					}					
				}
			);
			if ( i == 0 )
			{
				tableCol.setCellFactory( p->new EditingCell(this) );
			}
			this.tableView.getColumns().add(tableCol);
		}
		
		//this.tableView.getItems().addAll(this.dataLst);
		//this.tableView.setItems(this.dataLst);
		//this.tableView.getItems().addAll(this.obsDataLst);
		this.tableView.setItems(this.obsDataLst);
	}
	
	private void setContextMenu()
	{
		ContextMenu tblContextMenu = new ContextMenu();
		
		tblContextMenu.getItems().addAll
		(
			new MenuItem("tblA"),
			new MenuItem("tblB")
		);
		
		this.tableView.setContextMenu(tblContextMenu);
	}
	
	private void setContextMenu( TableColumn<List<String>,String> tblColumn )
	{
		ContextMenu tblColumnContextMenu = new ContextMenu();
		
		tblColumnContextMenu.getItems().addAll
		(
			new MenuItem( tblColumn.getText()+":A" ),
			new MenuItem( tblColumn.getText()+":B" )
		);
		
		tblColumn.setContextMenu(tblColumnContextMenu);
	}
	
	public void selectRecord( int id, MouseEvent event )
	{
		if ( event.isShiftDown() )
		{
			System.out.println( "RowId Add." + this.selectedRowLst.size() );
			this.selectedRowLst.add(id);
		}
		else
		{
			System.out.println( "RowId Clear." + this.selectedRowLst.size() );
			this.selectedRowLst.clear();
			this.selectedRowLst.add(id);
		}
		tableView.getSelectionModel().clearSelection();
		this.selectedRowLst.forEach( (rowId)->{System.out.println("rowId:"+rowId);tableView.getSelectionModel().select(rowId);} );
	}
	
	class EditingCell extends TableCell<List<String>, String>
	{
		private TextInputControl textInputCtrl = null;
		
		/*
		private List<Integer>  selectedRowLst = new ArrayList<>();
		
		public EditingCell()
		{
			this.addEventFilter
			(
				MouseEvent.MOUSE_CLICKED, 
				(event)->
				{
					System.out.println( "Clicked." );
					TableView<List<String>> tableView = this.getTableView();
					int id = this.getTableRow().getIndex();
					if ( event.isShiftDown() )
					{
						System.out.println( "RowId Add." + this.selectedRowLst.size() );
						this.selectedRowLst.add(id);
					}
					else
					{
						System.out.println( "RowId Clear." + this.selectedRowLst.size() );
						this.selectedRowLst.clear();
						this.selectedRowLst.add(id);
					}
					ObservableList<TableColumn<List<String>,?>> obsColLst = tableView.getColumns();
					//this.selectedRowLst.forEach( (rowId)->{tableView.getSelectionModel().selectRange(rowId,obsColLst.get(0),rowId,obsColLst.get(obsColLst.size()-1));} );
					//this.selectedRowLst.forEach( (rowId)->{tableView.getSelectionModel().clearSelection(rowId,null);} );
					
					//this.selectedRowLst.forEach( (rowId)->{tableView.getSelectionModel().select(rowId,null);} );
					tableView.getSelectionModel().clearSelection();
					//tableView.getSelectionModel().selectRange(this.selectedRowLst.get(0),obsColLst.get(0),this.selectedRowLst.get(this.selectedRowLst.size()-1),obsColLst.get(obsColLst.size()-1));
					this.selectedRowLst.forEach( (rowId)->{System.out.println("rowId:"+rowId);tableView.getSelectionModel().select(rowId);} );
					event.consume();
				}
			);
		}
		*/
		
		public EditingCell( TableViewListString app )
		{
			this.addEventFilter
			(
				MouseEvent.MOUSE_CLICKED, 
				(event)->
				{
					System.out.println( "Clicked." );
					int id = this.getTableRow().getIndex();
					app.selectRecord(id, event);
					event.consume();
				}
			);
		}
		
		/*
		 * (non-Javadoc)
		 * @see javafx.scene.control.TableCell#startEdit()
		 */
		@Override
		public void startEdit()
		{
			if ( !this.isEmpty() )
			{
				super.startEdit();
				this.createTextField();
				this.setText( null );
				this.setGraphic( this.textInputCtrl );
				this.textInputCtrl.selectAll();
				this.textInputCtrl.requestFocus();
			}
		}
		
		/*
		 * (non-Javadoc)
		 * @see javafx.scene.control.TableCell#cancelEdit()
		 */
		@Override
		public void cancelEdit()
		{
			super.cancelEdit();
			
			setText((String)getItem());
			setGraphic(null);
		}
		
		/**
		 * Callback for Cell
		 */
		@Override
		protected void updateItem( String item, boolean empty )
		{
			super.updateItem(item, empty);
			
            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textInputCtrl != null) {
                    	textInputCtrl.setText(getString());
                    }
                    setText(null);
                    setGraphic(textInputCtrl);
                } else {
                    setText(getString());
                    setGraphic(null);
                }
            }
		}
		
        private void createTextField()
        {
        	String str = getString();
        	int rtnStr = this.getCharCount( str, "\n" );
        	if ( rtnStr == 0 )
        	{
        		textInputCtrl = new TextField( str );
        	}
        	else
        	{
        		textInputCtrl = new TextArea( str );
        		((TextArea)textInputCtrl).setPrefRowCount( rtnStr );
        	}
        	textInputCtrl.setMinWidth(this.getWidth() - this.getGraphicTextGap()*2 );
        	textInputCtrl.focusedProperty().addListener
        	(
        		new ChangeListener<Boolean>()
        		{
	                @Override
	                public void changed
	                (
	                	ObservableValue<? extends Boolean> arg0, 
	                    Boolean arg1, 
	                    Boolean arg2
	                )
	                {
	                    if (!arg2)
	                    {
	        				// To copy data, open an edit cell.
	        				// Do not change the cell data, no matter what an user inputs
	                        commitEdit(textInputCtrl.getText());
	                    }
	                }
        		}
        	);
        }
        
        private String getString()
        {
            return getItem() == null ? "" : getItem().toString();
        }
        
    	public int getCharCount( String strSrc, String strChk )
    	{
    		if ( strSrc == null || strChk == null )
    		{
    			return 0;
    		}
    		else
    		{
    			return strSrc.length() - strSrc.replace( strChk, "" ).length();
    		}
    	}
    }	
}
