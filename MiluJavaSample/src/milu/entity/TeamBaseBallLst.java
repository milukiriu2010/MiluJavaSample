package milu.entity;

import java.util.ArrayList;
import java.util.List;

import milu.entity.TeamBaseBall.LEAGUE;

public class TeamBaseBallLst {
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

        return list;
	}
}
