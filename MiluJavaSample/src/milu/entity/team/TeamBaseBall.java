package milu.entity.team;

import java.util.ArrayList;
import java.util.List;

public class TeamBaseBall extends TeamAbs {
	public enum LEAGUE
	{
		CENTRAL,
		PACIFIC,
		UNKOWN
	}
	
	private LEAGUE league = LEAGUE.UNKOWN;
	
	/*
	public TeamBaseBall()
	{
	}
	*/
	
	public LEAGUE getLeague()
	{
		return this.league;
	}

	public void setLeague( LEAGUE league )
	{
		this.league = league;
	}
	
	@Override
	public TeamBaseBall clone() throws CloneNotSupportedException
	{
		TeamBaseBall clone = (TeamBaseBall) super.clone();
		return (TeamBaseBall)clone;
	}	

	public static List<TeamBaseBall> createLst() {
        List<TeamBaseBall> list = new ArrayList<TeamBaseBall>();
        
        TeamBaseBall tigers = new TeamBaseBall();
        tigers.setType("baseball");
        tigers.setName("tigers");
        tigers.addPlayer("nishi");
        tigers.addPlayer("takahashi");
        tigers.putYearPosMap(2017, 2);
        tigers.putYearPosMap(2018, 6);
        tigers.putYearPosMap(2019, 3);
        tigers.setLeague(LEAGUE.CENTRAL);
        list.add(tigers);
        
        TeamBaseBall giants = new TeamBaseBall();
        giants.setType("baseball");
        giants.setName("giants");
        giants.addPlayer("sugano");
        giants.addPlayer("takahashi");
        giants.putYearPosMap(2017, 4);
        giants.putYearPosMap(2018, 3);
        giants.putYearPosMap(2019, 1);
        giants.setLeague(LEAGUE.CENTRAL);
        list.add(giants);
        
        TeamBaseBall carp = new TeamBaseBall();
        carp.setType("baseball");
        carp.setName("carp");
        carp.addPlayer("osera");
        carp.addPlayer("nomura");
        carp.putYearPosMap(2017, 1);
        carp.putYearPosMap(2018, 1);
        carp.putYearPosMap(2019, 4);
        carp.setLeague(LEAGUE.CENTRAL);
        list.add(carp);
        
        TeamBaseBall baysters = new TeamBaseBall();
        baysters.setType("baseball");
        baysters.setName("carp");
        baysters.addPlayer("imanaga");
        baysters.addPlayer("hamaguchi");
        baysters.putYearPosMap(2017, 3);
        baysters.putYearPosMap(2018, 4);
        baysters.putYearPosMap(2019, 2);
        baysters.setLeague(LEAGUE.CENTRAL);
        list.add(baysters);
        
        TeamBaseBall swallows = new TeamBaseBall();
        swallows.setType("baseball");
        swallows.setName("carp");
        swallows.addPlayer("ishikawa");
        swallows.addPlayer("ogawa");
        swallows.putYearPosMap(2017, 6);
        swallows.putYearPosMap(2018, 2);
        swallows.putYearPosMap(2019, 6);
        swallows.setLeague(LEAGUE.CENTRAL);
        list.add(swallows);
        
        TeamBaseBall dragons = new TeamBaseBall();
        dragons.setType("baseball");
        dragons.setName("dragons");
        dragons.addPlayer("ohno");
        dragons.addPlayer("yanagi");
        dragons.putYearPosMap(2017, 5);
        dragons.putYearPosMap(2018, 5);
        dragons.putYearPosMap(2019, 5);
        dragons.setLeague(LEAGUE.CENTRAL);
        list.add(dragons);        
        
        TeamBaseBall hawks = new TeamBaseBall();
        hawks.setType("baseball");
        hawks.setName("hawks");
        hawks.addPlayer("senga");
        hawks.addPlayer("takahashi");
        hawks.putYearPosMap(2017, 1);
        hawks.putYearPosMap(2018, 2);
        hawks.putYearPosMap(2019, 2);
        hawks.setLeague(LEAGUE.PACIFIC);
        list.add(hawks);        
        
        TeamBaseBall lions = new TeamBaseBall();
        lions.setType("baseball");
        lions.setName("lions");
        lions.addPlayer("imai");
        lions.addPlayer("takahashi");
        lions.putYearPosMap(2017, 2);
        lions.putYearPosMap(2018, 1);
        lions.putYearPosMap(2019, 1);
        lions.setLeague(LEAGUE.PACIFIC);
        list.add(lions);        
        
        TeamBaseBall eagles = new TeamBaseBall();
        eagles.setType("baseball");
        eagles.setName("eagles");
        eagles.addPlayer("norimoto");
        eagles.addPlayer("kishi");
        eagles.putYearPosMap(2017, 3);
        eagles.putYearPosMap(2018, 6);
        eagles.putYearPosMap(2019, 3);
        eagles.setLeague(LEAGUE.PACIFIC);
        list.add(eagles);        
        
        TeamBaseBall marines = new TeamBaseBall();
        marines.setType("baseball");
        marines.setName("lions");
        marines.addPlayer("ishikawa");
        marines.addPlayer("miwa");
        marines.putYearPosMap(2017, 6);
        marines.putYearPosMap(2018, 5);
        marines.putYearPosMap(2019, 4);
        marines.setLeague(LEAGUE.PACIFIC);
        list.add(marines);        
        
        TeamBaseBall fighters = new TeamBaseBall();
        fighters.setType("baseball");
        fighters.setName("fighters");
        fighters.addPlayer("uesawa");
        fighters.addPlayer("kaneko");
        fighters.putYearPosMap(2017, 5);
        fighters.putYearPosMap(2018, 3);
        fighters.putYearPosMap(2019, 5);
        fighters.setLeague(LEAGUE.PACIFIC);
        list.add(fighters);        
        
        TeamBaseBall baffalos = new TeamBaseBall();
        baffalos.setType("baseball");
        baffalos.setName("baffalos");
        baffalos.addPlayer("yamaoka");
        baffalos.addPlayer("yamamoto");
        baffalos.putYearPosMap(2017, 4);
        baffalos.putYearPosMap(2018, 4);
        baffalos.putYearPosMap(2019, 6);
        baffalos.setLeague(LEAGUE.PACIFIC);
        list.add(baffalos);        

        return list;
	}

}
