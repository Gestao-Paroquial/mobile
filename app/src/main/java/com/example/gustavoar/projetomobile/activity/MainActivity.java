package com.example.gustavoar.projetomobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gustavoar.projetomobile.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.action_buscar);
        SearchView searchView = (SearchView) item.getActionView();
        // Listener que espera a ação de buscar
        searchView.setOnQueryTextListener(onSearch());

        // Recuperar  botão de compartilhar
        MenuItem shareItem = menu.findItem(R.id.action_share);
        ShareActionProvider share = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
        //Listener que espera a ação de compartilhar
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
            Toast.makeText(MainActivity.this,
                    "Config",
                    Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_share) {
            Toast.makeText(MainActivity.this,
                    "Compartilhar",
                    Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_sair) {
            Toast.makeText(MainActivity.this,
                    "Sair",
                    Toast.LENGTH_SHORT).show();
            clickSair();
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

        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {
                StringBuffer textoRetorno = new StringBuffer();
                textoRetorno.append(data.getStringExtra("nomeMembro"));
                textoRetorno.append("\n");
                textoRetorno.append(data.getStringExtra("emailMembro"));
                textoRetorno.append("\n");
                textoRetorno.append(data.getStringExtra("telefoneMembro"));

                TextView texto = (TextView) findViewById(R.id.textoInicial);
                texto.setText(textoRetorno.toString());

            }
        }
    }
}
