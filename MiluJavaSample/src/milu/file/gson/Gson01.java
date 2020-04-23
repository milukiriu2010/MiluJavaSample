package milu.file.gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import milu.entity.TeamBaseBall;

public class Gson01 {
    public static void main(String[] args) {
        List<TeamBaseBall> list = new ArrayList<TeamBaseBall>();
        
        TeamBaseBall tigers = new TeamBaseBall();
        tigers.setType("baseball");
        tigers.setName("tigers");
        tigers.addPlayer("nomi");
        tigers.addPlayer("fujinami");
        tigers.putYearPosMap(2018, 6);
        tigers.putYearPosMap(2019, 3);
        list.add(tigers);
        
        TeamBaseBall giants = new TeamBaseBall();
        giants.setType("baseball");
        giants.setName("giants");
        giants.addPlayer("sugano");
        giants.addPlayer("sawamura");
        giants.putYearPosMap(2018, 3);
        giants.putYearPosMap(2019, 1);
        list.add(giants);
        
        // オブジェクトのリスト⇒JSONに変換
        Gson gson = new Gson();
        Type type = new TypeToken<List<TeamBaseBall>>() {}.getType();
        String json = gson.toJson(list, type);
        System.out.println(json);
        
        // JSON⇒オブジェクトのリストに変換
        List<TeamBaseBall> fromJson = gson.fromJson(json, type);
        for (TeamBaseBall team : fromJson) {
        	System.out.println(team);
        }
    }
}
