package com.example.pc.robabikia.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Pc on 3/14/2018.
 */

public class StoreManger {
    public static void saveSharedpref(Context context,String key,String value){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key,value);
        editor.commit();
    }
    public static String getSharedpref(Context context, String key,String defaultvalue){
        String getEamil;
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        getEamil = prefs.getString(key,defaultvalue);
        return getEamil;

    }


}
