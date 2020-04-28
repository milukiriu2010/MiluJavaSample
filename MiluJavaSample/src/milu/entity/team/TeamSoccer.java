package milu.entity.team;

import java.util.ArrayList;
import java.util.List;

public class TeamSoccer extends TeamAbs {
	private int level = -1;

	public int getLevel()
	{
		return this.level;
	}
	
	public void setLevel( int level )
	{
		this.level = level;
	}
	
	@Override
	public TeamSoccer clone() throws CloneNotSupportedException
	{
		TeamAbs clone = super.clone();
		return (TeamSoccer)clone;
	}
	
	public static List<TeamSoccer> createLst() {
		List<TeamSoccer> list = new ArrayList<TeamSoccer>();
		
		TeamSoccer frontale = new TeamSoccer();
		frontale.setType("soccer");
		frontale.setName("frontale");
		frontale.addPlayer("damiano");
		frontale.addPlayer("kobayashi");
		frontale.putYearPosMap(2017, 1);
		frontale.putYearPosMap(2018, 1);
		frontale.putYearPosMap(2019, 4);
		frontale.setLevel(1);
		list.add(frontale);
		
		TeamSoccer antlers = new TeamSoccer();
		antlers.setType("soccer");
		antlers.setName("antlers");
		antlers.addPlayer("everaldo");
		antlers.addPlayer("ito");
		antlers.putYearPosMap(2017, 2);
		antlers.putYearPosMap(2018, 3);
		antlers.putYearPosMap(2019, 3);
		antlers.setLevel(1);
		list.add(antlers);
		
		TeamSoccer cerezo = new TeamSoccer();
		cerezo.setType("soccer");
		cerezo.setName("cerezo");
		cerezo.addPlayer("kakiya");
		cerezo.addPlayer("tokura");
		cerezo.putYearPosMap(2017, 3);
		cerezo.putYearPosMap(2018, 7);
		cerezo.putYearPosMap(2019, 5);
		cerezo.setLevel(1);
		list.add(cerezo);
		
		TeamSoccer verdy = new TeamSoccer();
		verdy.setType("soccer");
		verdy.setName("verdy");
		verdy.addPlayer("leandro");
		verdy.addPlayer("okubo");
		verdy.putYearPosMap(2017, 5);
		verdy.putYearPosMap(2018, 6);
		verdy.putYearPosMap(2019, 13);
		verdy.setLevel(2);
		list.add(verdy);
		
		TeamSoccer zelvia = new TeamSoccer();
		zelvia.setType("soccer");
		zelvia.setName("zelvia");
		zelvia.addPlayer("masovic");
		zelvia.addPlayer("stefan");
		zelvia.putYearPosMap(2017, 16);
		zelvia.putYearPosMap(2018, 4);
		zelvia.putYearPosMap(2019, 18);
		zelvia.setLevel(2);
		list.add(zelvia);		
		
		return list;
	}
}
