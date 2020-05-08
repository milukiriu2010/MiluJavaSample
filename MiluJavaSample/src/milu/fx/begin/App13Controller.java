package milu.fx.begin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

// --------------------------------------------------------------
// FXML+CSS+JavaActionでGUIをデザイン
// --------------------------------------------------------------
// https://www.tuyano.com/index3?id=7346003&page=4
// --------------------------------------------------------------
public class App13Controller {
    @FXML Label label1;
    @FXML TextField field1;
     
    @FXML
    protected void doAction(ActionEvent ev){
        String str = field1.getText();
        str = "あなたは、「" + str + "」と書いた。";
        label1.setText(str);
    }
}
