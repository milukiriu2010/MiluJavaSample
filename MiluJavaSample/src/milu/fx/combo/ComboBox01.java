package milu.fx.combo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

// --------------------------------------------------------------
// コンボボックスの練習
// --------------------------------------------------------------
public class ComboBox01 extends Application {

    final Button button = new Button ("Send");
    final Label notification = new Label ();
    final TextField subject = new TextField("");
    final TextArea text = new TextArea ("");
    
    String address = " ";

    public static void main(String[] args) {
        launch(args);
    }
	
	@Override
	public void start(Stage stage) throws Exception {
        stage.setTitle("ComboBox01");
        Scene scene = new Scene(new Group(), 450, 300);
        
        final ComboBox<String> emailComboBox = new ComboBox<String>();
        emailComboBox.getItems().addAll(
            "jacob.smith@example.com",
            "isabella.johnson@example.com",
            "ethan.williams@example.com",
            "emma.jones@example.com",
            "michael.brown@example.com"  
        );
        
        emailComboBox.setPromptText("Email address");
        emailComboBox.setEditable(true);
        
        // --------------------------------------------------------------------------
        // 以下のかわりにラムダを使う
        // --------------------------------------------------------------------------
        // emailComboBox.valueProperty().addListener(new ChangeListener<String>() {
        //    @Override 
        //    public void changed(ObservableValue ov, String t, String t1) {                
        //        address = t1;                
        //    }
        // });        
        // --------------------------------------------------------------------------
        emailComboBox.valueProperty().addListener( (ov,t,t1) -> {
        	address = t1;
        });
        
        final ComboBox<String> priorityComboBox = new ComboBox<String>();
        priorityComboBox.getItems().addAll(
            "Highest",
            "High",
            "Normal",
            "Low",
            "Lowest" 
        );   

        priorityComboBox.setValue("Normal");
        
        // ---------------
        // 送信ボタン押下
        // ---------------
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (emailComboBox.getValue() != null && 
                    !emailComboBox.getValue().toString().isEmpty()){
                        notification.setText("Your message was successfully sent"
                            + " to " + address);   
                        emailComboBox.setValue(null);
                        if (priorityComboBox.getValue() != null && 
                            !priorityComboBox.getValue().toString().isEmpty()){
                                priorityComboBox.setValue(null);
                            }
                        subject.clear();
                        text.clear();
                }
                else {
                    notification.setText("You have not selected a recipient!"); 
                }
            }
        });        
        
        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(new Label("To: "), 0, 0);
        grid.add(emailComboBox, 1, 0);
        grid.add(new Label("Priority: "), 2, 0);
        grid.add(priorityComboBox, 3, 0);
        grid.add(new Label("Subject: "), 0, 1);
        grid.add(subject, 1, 1, 3, 1);            
        grid.add(text, 0, 2, 4, 1);
        grid.add(button, 0, 3);
        grid.add(notification, 1, 3, 3, 1);
        
        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
	}

}
