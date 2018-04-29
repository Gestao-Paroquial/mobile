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

public class MensagemAdapter  extends BaseAdapter {

    private List<MensagemParoco> mensagensParoco;

    Context contexto;

    public MensagemAdapter(Context contexto, List<MensagemParoco> mensagemParocos){

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

        // Infla a View
        View viewText = LayoutInflater.from(contexto)
                .inflate(R.layout.tela_inicial_itens, parent, false);
        // Procura elementos de tela para atualizar
        TextView t = (TextView)viewText.findViewById(R.id.textItemList);
        MensagemParoco msg = mensagensParoco.get(position);
        t.setText(msg.getId() + " - " + msg.getTitulo());

        return viewText;
    }
}
