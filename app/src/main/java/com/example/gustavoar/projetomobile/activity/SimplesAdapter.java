package com.example.gustavoar.projetomobile.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.gustavoar.projetomobile.R;
import com.example.gustavoar.projetomobile.model.MensagemParoco;

import java.util.List;

/**
 * Created by ocimar on 09/04/2018.
 */

public class SimplesAdapter extends BaseAdapter {

    private List<MensagemParoco> mensagensParoco;

    Context contexto;

    public SimplesAdapter(Context contexto, List<MensagemParoco> mensagemParocos){

        this.contexto = contexto;
        this.mensagensParoco = mensagemParocos;
    }

    @Override
    public int getCount() {
        return mensagensParoco.size();
    }

    @Override
    public Object getItem(int position) {
        return mensagensParoco.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MensagemParoco msgParoco = mensagensParoco.get(position);

        View viewText = LayoutInflater.from(contexto).inflate(R.layout.tela_inicial_itens,parent,false);

        TextView t = (TextView) viewText.findViewById(R.id.textItemList);

        t.setText(msgParoco.getId() + "-" + msgParoco.getTitulo());

        return viewText;
    }
}
