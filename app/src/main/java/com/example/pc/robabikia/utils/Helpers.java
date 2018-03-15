package com.example.pc.robabikia.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Pc on 3/14/2018.
 */

public class Helpers {

    public static void print(Context context,String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

}
