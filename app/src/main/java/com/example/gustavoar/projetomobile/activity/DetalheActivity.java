package com.example.gustavoar.projetomobile.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gustavoar.projetomobile.R;
import com.example.gustavoar.projetomobile.model.MensagemParoco;

public class DetalheActivity extends AppCompatActivity {

    MensagemParoco msg;
    TextView tituloDetalhe;
    TextView mensagemDetalhe;
    TextView subtituloDetalhe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        msg = new MensagemParoco();

        Intent i = getIntent();

        msg = (MensagemParoco) i.getSerializableExtra("mensagem");

        tituloDetalhe = findViewById(R.id.tituloDetalhe);
        tituloDetalhe.setText(msg.getTitulo());

        mensagemDetalhe = findViewById(R.id.mensagemDetalhe);
        mensagemDetalhe.setText(msg.getMensagem());

        subtituloDetalhe = findViewById(R.id.subtituloDetalhe);
        subtituloDetalhe.setText(msg.getSubtitulo());

        Button btnAlterar = (Button) findViewById(R.id.botaoAlterar);

        Button btnExcluir = (Button) findViewById(R.id.botaoExcluir);

        btnAlterar.setOnClickListener(clickAlterar());

        btnExcluir.setOnClickListener(clickExcluir());

    }

    public View.OnClickListener clickAlterar() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetalheActivity.this, CadastroActivity.class);

                intent.putExtra("mensagem", msg);

                startActivity(intent);
                finish();
            }
        };
    }

    public View.OnClickListener clickExcluir() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                ParoquiaDB paroquiaDB = new ParoquiaDB(DetalheActivity.this);
                paroquiaDB.delete(msg);
                Intent returnIntent = new Intent(DetalheActivity.this,MainActivity.class);
                startActivity(returnIntent);
                finish();
            }
        };
    }

}
