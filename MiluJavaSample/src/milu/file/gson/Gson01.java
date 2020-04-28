package milu.file.gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import milu.entity.team.TeamAbs;
import milu.entity.team.TeamBaseBall;
import milu.entity.team.TeamSoccer;

// -------------------------------------------
// �E�I�u�W�F�N�g�̃��X�g��JSON�ɕϊ�
// �EJSON�˃I�u�W�F�N�g�̃��X�g�ɕϊ�
// -------------------------------------------
public class Gson01 {
    public static void main(String[] args) {
        List<TeamBaseBall> listBaseBall = TeamBaseBall.createLst();
        List<TeamSoccer> listSoccer = TeamSoccer.createLst();
        
        List<TeamAbs> list = new ArrayList<>();
        list.addAll(listBaseBall);
        list.addAll(listSoccer);
        
        // �I�u�W�F�N�g�̃��X�g��JSON�ɕϊ�
        // Gson gson = new Gson();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type type = new TypeToken<List<TeamBaseBall>>() {}.getType();
        String json = gson.toJson(list, type);
        System.out.println(json);
        
        // JSON�˃I�u�W�F�N�g�̃��X�g�ɕϊ�
        List<TeamBaseBall> fromJson = gson.fromJson(json, type);
        for (TeamBaseBall team : fromJson) {
        	System.out.println(team);
        }
    }
}
