package com.example.gustavoar.projetomobile.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gustavoar.projetomobile.R;
import com.example.gustavoar.projetomobile.model.MensagemParoco;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button botao = (Button) findViewById(R.id.botaoCadastro);
        botao.setOnClickListener(clickCadastro());
    }

    public View.OnClickListener clickCadastro() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EditText titulo = (EditText) findViewById(R.id.titulo);
                EditText subtitulo = (EditText) findViewById(R.id.subtitulo);
                EditText mensagem = (EditText) findViewById(R.id.mensagem);

                MensagemParoco msg = new MensagemParoco();

                msg.setTitulo(titulo.getText().toString());
                msg.setSubtitulo(subtitulo.getText().toString());
                msg.setMensagem(mensagem.getText().toString());

                Intent returnIntent = new Intent();
                returnIntent.putExtra("titulo", msg.getTitulo());
                returnIntent.putExtra("subtitulo", msg.getSubtitulo());
                returnIntent.putExtra("mensagem", msg.getMensagem());


                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        };
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {
                StringBuffer textoRetorno = new StringBuffer();
                textoRetorno.append(data.getStringExtra("titulo"));
                textoRetorno.append("\n");
                textoRetorno.append(data.getStringExtra("subtitulo"));
                textoRetorno.append("\n");
                textoRetorno.append(data.getStringExtra("mensagem"));


            }
        }
    }
}
