package com.example.gustavoar.projetomobile.activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.gustavoar.projetomobile.model.MensagemParoco;

import java.util.ArrayList;
import java.util.List;

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

    // inserir uma nova mensagem ou atualizar existente
    public long save(MensagemParoco msg) {
        long id = msg.getId();
        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put("titulo", msg.getTitulo());
            values.put("subTitulo", msg.getSubtitulo());
            values.put("mensagem", msg.getMensagem());
            if (id != 0) {
                String _id = String.valueOf(id);
                String [] argsFiltro = new String[]{_id};
                // criar update mensagem set values = ... where _id = ?
                int count = db.update("mensagemParoco", values, "_id=?", argsFiltro);
                return count;
            } else {
                // criar insert into mensagem values (...)
                id = db.insert("mensagemParoco","", values);
                return id;
            }
        } finally {
            db.close();
        }

    }

    // remover mensagem
    public int delete(MensagemParoco msg){
        SQLiteDatabase db = getWritableDatabase();
        try{
            // criar delete from mensagem where _id = ?
            int count = db.delete("mensagemParoco", "_id=?", new String[]{String.valueOf(msg.getId())});
            return count;
        } finally {
            db.close();
        }
    }

    // retornar todas as cervejas
    public List<MensagemParoco> findAll() {

        SQLiteDatabase db =  getWritableDatabase();
        try {
            // criar select * from mensagemParoco

            Cursor c = db.query("mensagemParoco", null, null, null, null, null, null, null);

            return  toList(c);
        } finally {
            db.close();
        }
    }

    // lê o cursor e cria a lista de mensagens
    private List<MensagemParoco> toList(Cursor c) {
        List<MensagemParoco> mensagens = new ArrayList<MensagemParoco>();
        if (c.moveToFirst()) {
            do {
                MensagemParoco mensagemParoco = new MensagemParoco();
                mensagens.add(mensagemParoco);
                mensagemParoco.setId(c.getLong(c.getColumnIndex("_id")));
                mensagemParoco.setTitulo(c.getString(c.getColumnIndex("titulo")));
                mensagemParoco.setSubtitulo(c.getString(c.getColumnIndex("subTitulo")));
                mensagemParoco.setMensagem(c.getString(c.getColumnIndex("mensagem")));

            } while (c.moveToNext());
        }
        return mensagens;
    }

    // executa um SQL
    public void execSQL(String sql) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            db.execSQL(sql);
        }finally {
            db.close();
        }
    }

    // executa um SQL parâmetros
    public void execSQL(String sql, Object [] args) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            db.execSQL(sql, args);
        }finally {
            db.close();
        }
    }
}
