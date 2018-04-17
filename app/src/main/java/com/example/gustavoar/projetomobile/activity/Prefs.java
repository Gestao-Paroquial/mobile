package com.example.gustavoar.projetomobile.activity;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ocimar on 16/04/2018.
 */

public class Prefs {

    private static final String PREF_ID = "sgp";

    public static void setBoolean(Context contexto, String chave, boolean valor){

        SharedPreferences pref = contexto.getSharedPreferences(PREF_ID, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(chave,valor);
        editor.commit();
    }

    public static void setString(Context contexto, String chave, String valor){
        SharedPreferences pref = contexto.getSharedPreferences(PREF_ID, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(chave,valor);
        editor.commit();
    }

    public static boolean getBoolean(Context contexto, String chave){
        SharedPreferences pref = contexto.getSharedPreferences(PREF_ID, Context.MODE_PRIVATE);

        Boolean b = pref.getBoolean(chave,false);

        return b;
    }

    public static String getString(Context contexto, String chave){
        SharedPreferences pref = contexto.getSharedPreferences(PREF_ID, Context.MODE_PRIVATE);

        String s = pref.getString(chave,"");

        return s;
    }
}
