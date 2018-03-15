package com.example.pc.robabikia.utils;

import android.content.Context;
import android.content.ContextWrapper;

import com.example.pc.robabikia.MainActivity;
import com.example.pc.robabikia.model.News;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Pc on 3/14/2018.
 */

public class Connector {

    public static ArrayList<News> apiData(String response) throws JSONException {

        ArrayList<News> news=new ArrayList<>();
        JSONObject jsonObject=new JSONObject(response);
        JSONArray jsonArray=jsonObject.getJSONArray("articles");
        for(int i=0;i<jsonArray.length();i++){
            JSONObject item = jsonArray.getJSONObject(i);
            String title = item.getString("title");
            String description = item.getString("description");
            news.add(new News(title,description));

        }
        return news;
    }
}
