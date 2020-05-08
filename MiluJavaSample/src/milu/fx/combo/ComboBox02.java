package milu.fx.combo;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.util.StringConverter;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import milu.entity.team.TeamAbs;
import milu.entity.team.TeamBaseBall;
import milu.entity.team.TeamSoccer;

// https://stackoverflow.com/questions/19242747/javafx-editable-combobox-showing-tostring-on-item-selection?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
public class ComboBox02 extends Application {
	
	private ComboBox<TeamAbs>  teamComboBox = new ComboBox<>();
	
	List<TeamAbs>  teamList = new ArrayList<TeamAbs>();

	@Override
	public void start(Stage stage) throws Exception {
		List<TeamBaseBall> teamBaseBall = TeamBaseBall.createLst();
		List<TeamSoccer>   teamSoccer   = TeamSoccer.createLst();
		
		// チームリスト
		teamList.addAll(teamBaseBall);
		teamList.addAll(teamSoccer);
		
		// コンボボックスのプルダウンに表示する値を定義する
		// ここでは、チーム名+":"+チームタイプを返す
		this.teamComboBox.setConverter(
			new StringConverter<TeamAbs>(){
				@Override
				public String toString(TeamAbs team)
				{
					if ( team == null ) {
						return "";
					}
					else {
						return team.getName() + ":" + team.getType();
					}
				}
				
				@Override
				public TeamAbs fromString(String str) {
					//throw new UnsupportedOperationException();
					return null;
				}
			}
		);
		
		this.teamComboBox.getItems().addAll(this.teamList);
		
		BorderPane  brdPane = new BorderPane();
		brdPane.setTop(this.teamComboBox);
		
		Scene scene = new Scene( brdPane, 640, 480 );
		stage.setScene(scene);
		stage.show();
	}

    public static void main(String[] args) 
    {
        launch(args);
    }
}
