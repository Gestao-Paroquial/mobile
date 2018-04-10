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

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button botao  = (Button)findViewById(R.id.botaoCadastro);
        botao.setOnClickListener(clickCadastro());
    }

    public View.OnClickListener clickCadastro(){
        return new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                EditText nomeMembro = (EditText)findViewById(R.id.nomeMembro);
                EditText emailMembro = (EditText)findViewById(R.id.emailMembro);
                EditText membroTelefone = (EditText)findViewById(R.id.membroTelefone);

                String nomeMembroTxt = nomeMembro.getText().toString();
                String emailMembroTxt = emailMembro.getText().toString();
                String telefoneMembroTxt = membroTelefone.getText().toString();

                Intent returnIntent = new Intent();
                returnIntent.putExtra("nomeMembro",nomeMembroTxt);
                returnIntent.putExtra("emailMembro",emailMembroTxt);
                returnIntent.putExtra("telefoneMembro",telefoneMembroTxt);

                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        };
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home) {
            finish();
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {
                StringBuffer textoRetorno = new StringBuffer();
                textoRetorno.append(data.getStringExtra("nomeMembro"));
                textoRetorno.append("\n");
                textoRetorno.append(data.getStringExtra("emailMembro"));
                textoRetorno.append("\n");
                textoRetorno.append(data.getStringExtra("telefoneMembro"));


            }
        }
    }
}
