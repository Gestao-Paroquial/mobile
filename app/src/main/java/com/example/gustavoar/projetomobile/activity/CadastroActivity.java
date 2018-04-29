package com.example.gustavoar.projetomobile.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.gustavoar.projetomobile.R;
import com.example.gustavoar.projetomobile.model.MensagemParoco;

public class CadastroActivity extends AppCompatActivity {

    private MensagemParoco mensagemParoco;
    EditText titulo;
    EditText subTitulo;
    EditText mensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mensagemParoco = new MensagemParoco();
        titulo = (EditText) findViewById(R.id.titulo);
        subTitulo = (EditText) findViewById(R.id.subtitulo);
        mensagem = (EditText) findViewById(R.id.mensagem);

        Intent i = getIntent();

        mensagemParoco = (MensagemParoco) i.getSerializableExtra("mensagem");

        if(mensagemParoco != null) {
            titulo.setText(mensagemParoco.getTitulo());
            subTitulo.setText(mensagemParoco.getSubtitulo());
            mensagem.setText(mensagemParoco.getMensagem());
        }

        Button btnSalvar = (Button) findViewById(R.id.botaoCadastro);

        btnSalvar.setOnClickListener(clickCadastro());
    }

    public View.OnClickListener clickCadastro() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(mensagemParoco == null)
                    mensagemParoco = new MensagemParoco();
                mensagemParoco.setTitulo(titulo.getText().toString());
                mensagemParoco.setSubtitulo(subTitulo.getText().toString());
                mensagemParoco.setMensagem(mensagem.getText().toString());

                ParoquiaDB paroquiaDB = new ParoquiaDB(CadastroActivity.this);

                paroquiaDB.save(mensagemParoco);

                Intent returnIntent = new Intent(CadastroActivity.this,MainActivity.class);

                startActivity(returnIntent);

                finish();

            }
        };
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {

            Intent it = new Intent(CadastroActivity.this, MainActivity.class);
            startActivity(it);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
