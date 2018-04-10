package com.example.gustavoar.projetomobile.activity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by ocimar on 09/04/2018.
 */

public class SimplesAdapter extends BaseAdapter {

    public String [] listaCervejas = new String[]{
      "Paulaner", "duvel", "Sierra Nevada"
    };

    Context contexto;

    public SimplesAdapter(Context contexto){
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return listaCervejas.length;
    }

    @Override
    public Object getItem(int position) {
        return listaCervejas[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String cerveja = listaCervejas[position];

        TextView t = new TextView(contexto);

        t.setText(cerveja);

        return t;
    }
}
