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

import com.example.gustavoar.projetomobile.R;
import com.example.gustavoar.projetomobile.model.MensagemParoco;

public class DetalheActivity extends AppCompatActivity {

    TextView id;
    TextView tituloDetalhe;
    TextView mensagemDetalhe;
    TextView subtituloDetalhe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        id = findViewById(R.id.id);
        id.setText(getIntent().getStringExtra("id"));

        tituloDetalhe = findViewById(R.id.tituloDetalhe);
        tituloDetalhe.setText(getIntent().getStringExtra("titulo"));

        mensagemDetalhe = findViewById(R.id.mensagemDetalhe);
        mensagemDetalhe.setText(getIntent().getStringExtra("mensagem"));

        subtituloDetalhe = findViewById(R.id.subtituloDetalhe);
        subtituloDetalhe.setText(getIntent().getStringExtra("subtitulo"));

        Button btnAlterar = (Button) findViewById(R.id.botaoAlterar);

        Button btnExcluir = (Button) findViewById(R.id.botaoExcluir);

    }

    public View.OnClickListener clickAlterar() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetalheActivity.this, CadastroActivity.class);

                intent.putExtra("id", id.getText());
                intent.putExtra("titulo", tituloDetalhe.getText());
                intent.putExtra("subtitulo", subtituloDetalhe.getText());
                intent.putExtra("mensagem", mensagemDetalhe.getText());

                startActivity(intent);
                finish();
            }
        };
    }

}
