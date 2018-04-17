package com.example.gustavoar.projetomobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gustavoar.projetomobile.R;

public class LoginActivity extends AppCompatActivity {

    private Button botaoEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        botaoEntrar = findViewById(R.id.buttonEntrar);

        Boolean lembrar = Prefs.getBoolean(LoginActivity.this,"lembrarUsuario");
        EditText campoUsuario = (EditText) findViewById(R.id.editEmail);
        EditText campoSenha = (EditText) findViewById(R.id.editSenha);

        if(lembrar){
            campoUsuario.setText(Prefs.getString(LoginActivity.this, "usuario"));
            campoSenha.setText(Prefs.getString(LoginActivity.this, "senha"));
            CheckBox guardarSenha = (CheckBox) findViewById(R.id.lembrarUsuario);
            guardarSenha.setChecked(true);
        }

        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTelaPrincipal();
            }
        });
    }

    public void abrirTelaPrincipal(){
        EditText campoUsuario = (EditText) findViewById(R.id.editEmail);
        EditText campoSenha = (EditText) findViewById(R.id.editSenha);
        CheckBox guardarSenha = (CheckBox) findViewById(R.id.lembrarUsuario);
        String txtUsuario = campoUsuario.getText().toString();
        String txtSenha = campoSenha.getText().toString();

        if (guardarSenha.isChecked()){
            Prefs.setString(LoginActivity.this, "usuario",txtUsuario);
            Prefs.setString(LoginActivity.this, "senha",txtSenha);
            Prefs.setBoolean(LoginActivity.this,"lembrarUsuario",guardarSenha.isChecked());
        }else{
            Prefs.setString(LoginActivity.this, "usuario","");
            Prefs.setString(LoginActivity.this, "senha","");
            Prefs.setBoolean(LoginActivity.this,"lembrarUsuario",false);
        }
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}
