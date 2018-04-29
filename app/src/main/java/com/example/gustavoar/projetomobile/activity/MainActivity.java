package com.example.gustavoar.projetomobile.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gustavoar.projetomobile.R;
import com.example.gustavoar.projetomobile.model.MensagemParoco;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<MensagemParoco> mensagemParocos = new ArrayList<>();
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.Lista);

        // Criar objeto de paroquiaDB
        ParoquiaDB paroquiaDB = new ParoquiaDB(MainActivity.this);
        // Procurar mensagens e armazenar na
        // variavel de classe mensagens
        mensagemParocos = paroquiaDB.findAll();

        // Adapater de mensagens
        lista.setAdapter(new MensagemAdapter(MainActivity.this, mensagemParocos));

        lista.setOnItemClickListener(new ListView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this,"clicou!!!",Toast.LENGTH_LONG).show();

                MensagemParoco msg = mensagemParocos.get(position);

                Intent detailIt = new Intent(MainActivity.this, DetalheActivity.class);

                detailIt.putExtra("mensagem", msg);

                startActivity(detailIt);
                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.action_buscar);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(onSearch());

        MenuItem shareItem = menu.findItem(R.id.action_share);
        ShareActionProvider share = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
        share.setShareIntent(getDefautIntent());
        return true;
    }

    private Intent getDefautIntent() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/*");
        String textoShare = "Confira o nosso site: http://165.227.197.233";

        intent.putExtra(Intent.EXTRA_TEXT, textoShare);
        return intent;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_buscar) {
            Toast.makeText(MainActivity.this,
                    "Buscar",
                    Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_adicionar) {
            Toast.makeText(MainActivity.this,
                    "Adicionar",
                    Toast.LENGTH_SHORT).show();
            Intent it = new Intent(MainActivity.this, CadastroActivity.class);
            startActivityForResult(it, 1);
        } else if (id == R.id.action_config) {
            startActivity(new Intent(MainActivity.this,ConfiguracoesActivity.class));
        } else if (id == R.id.action_share) {
            Toast.makeText(MainActivity.this,
                    "Compartilhar",
                    Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_sair) {
            Toast.makeText(MainActivity.this,
                    "Sair",
                    Toast.LENGTH_SHORT).show();
            clickSair();
        } else if (id == R.id.action_map){
            Intent it = new Intent(MainActivity.this, LocalizacaoActivity.class);
            startActivity(it);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private SearchView.OnQueryTextListener onSearch() {
        return new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                query = query.toLowerCase();
                Toast.makeText(MainActivity.this, "Sua busca foi: " + query, Toast.LENGTH_SHORT).show();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        };
    }

    public void clickSair() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

                // Criar objeto de ParoquiaDB
                ParoquiaDB paroquiaDB = new ParoquiaDB(MainActivity.this);
                // Procurar mensagens e armazena navariavel de classe mensagemParocos
                mensagemParocos = paroquiaDB.findAll();

                lista.setAdapter(new SimplesAdapter(MainActivity.this, mensagemParocos));
    }
}
