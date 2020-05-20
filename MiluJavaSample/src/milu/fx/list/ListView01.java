package milu.fx.list;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import javafx.scene.control.ListCell;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;
import java.util.List;

import milu.entity.team.TeamAbs;
import milu.entity.team.TeamBaseBall;
import milu.entity.team.TeamSoccer;

// リストビューにユーザクラスを表示する
public class ListView01 extends Application {
	ListView<TeamAbs>  teamListView = new ListView<>();
	
	List<TeamAbs>  teamList = new ArrayList<>();
	
	@Override
	public void start(Stage stage) throws Exception {
        List<TeamBaseBall> listBaseBall = TeamBaseBall.createLst();
        List<TeamSoccer> listSoccer = TeamSoccer.createLst();
        
        this.teamList.addAll(listBaseBall);
        this.teamList.addAll(listSoccer);
        
		this.teamListView.getItems().addAll(this.teamList);
		
		// "チーム名+チームタイプ"をリストに表示する
		this.teamListView.setCellFactory( val -> new ListCell<TeamAbs>() {
			@Override
			protected void updateItem(TeamAbs team, boolean empty)
			{
				super.updateItem( team, empty );
				if ( empty || team == null || team.getName() == null )
				{
					setText(null);
				}
				else
				{
					setText(team.getName() + ":" + team.getType());
				}
			}
		});
		
		BorderPane  brdPane = new BorderPane();
		brdPane.setTop(this.teamListView);
		
		Scene scene = new Scene( brdPane, 640, 480 );
		stage.setScene(scene);
		stage.show();        
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
