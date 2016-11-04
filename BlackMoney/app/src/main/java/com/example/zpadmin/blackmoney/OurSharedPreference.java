package com.example.zpadmin.blackmoney;

import android.app.Activity;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZP Admin on 2016-11-04.
 */

public class OurSharedPreference extends Activity{
    static int receiveId = 0;
    static int paybackId = 0;
    SharedPreferences  mPrefs = getPreferences(MODE_PRIVATE);

    ArrayList<Deal> getReceiveDeal(){
        Gson gson = new Gson();
        String json = mPrefs.getString("receive", "");
        if(json.isEmpty()){
            return new ArrayList<Deal>();
        }
        Type type = new TypeToken<List<Deal>>(){}.getType();
        return gson.fromJson(json, type);
    }

    ArrayList<Deal> getPaybackDeal(){
        Gson gson = new Gson();
        String json = mPrefs.getString("payback", "");
        if(json.isEmpty()){
            return new ArrayList<Deal>();
        }
        Type type = new TypeToken<List<Deal>>(){}.getType();
        return gson.fromJson(json, type);
    }

    public OurSharedPreference(){

    }

    public void saveReceiveDeal(ArrayList<Deal> dealarray){
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(dealarray);
        prefsEditor.putString("receive", json);
        prefsEditor.commit();
    }
    public void savePaybackDeal(ArrayList<Deal> dealarray){
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(dealarray);
        prefsEditor.putString("payback", json);
        prefsEditor.commit();
    }
}
