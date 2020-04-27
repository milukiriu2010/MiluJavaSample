package milu.file.gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import milu.entity.TeamBaseBall;
import milu.entity.TeamBaseBallLst;

// -------------------------------------------
// �E�I�u�W�F�N�g�̃��X�g��JSON�ɕϊ�
// �EJSON�˃I�u�W�F�N�g�̃��X�g�ɕϊ�
// -------------------------------------------
public class Gson01 {
    public static void main(String[] args) {
        List<TeamBaseBall> list = TeamBaseBallLst.createLst();
        
        // �I�u�W�F�N�g�̃��X�g��JSON�ɕϊ�
        Gson gson = new Gson();
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
