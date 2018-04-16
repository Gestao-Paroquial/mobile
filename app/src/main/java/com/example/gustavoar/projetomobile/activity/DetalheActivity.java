package com.example.gustavoar.projetomobile.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.gustavoar.projetomobile.R;

public class DetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        TextView tituloDetalhe = findViewById(R.id.tituloDetalhe);
        tituloDetalhe.setText(getIntent().getStringExtra("titulo"));

        TextView mensagemDetalhe = findViewById(R.id.mensagemDetalhe);
        mensagemDetalhe.setText(getIntent().getStringExtra("mensagem"));

        TextView subtituloDetalhe = findViewById(R.id.subtituloDetalhe);
        subtituloDetalhe.setText(getIntent().getStringExtra("subtitulo"));

    }

}
