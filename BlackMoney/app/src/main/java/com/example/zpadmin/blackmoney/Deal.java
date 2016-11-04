package com.example.zpadmin.blackmoney;

import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by ZP Admin on 2016-11-04.
 */

public class Deal {
    String id, title, day;
    ArrayList<String> person, money;
    Deal(String id, String title, String day, ArrayList<String> person, ArrayList<String> money){
        this.id = id;
        this.title = title;
        this.day = day;
        this.person = person;
        this.money = money;
    }
    @Override
    public String toString() {
        String tmp = "";
        tmp += "id : " + id + "\ntitle : " + title + "\nday" + day;
        Gson gson = new Gson();
        tmp += "\nperson" + gson.toJson(person);
        tmp += "\nmoney" + gson.toJson(money);
        return tmp;
    }
}
