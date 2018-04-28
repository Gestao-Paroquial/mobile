package com.example.gustavoar.projetomobile.activity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ocimar on 23/04/2018.
 */

public class ParoquiaDB extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "paroquia_db.sqlite";
    // Versao do BD
    public static final int VERSAO_BANCO = 1;

    public ParoquiaDB(Context context){
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists mensagemParoco (" +
                "_id integer primary key autoincrement, " +
                "titulo text, subTitulo text, mensagem text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
