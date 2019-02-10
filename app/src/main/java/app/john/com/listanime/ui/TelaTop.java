package app.john.com.listanime.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.john.com.listanime.R;
import app.john.com.listanime.adapters.AnimeRVAdapter;
import app.john.com.listanime.intermediario.Controle;
import app.john.com.listanime.modelos.Anime;

public class TelaTop extends AppCompatActivity {

    private EditText tituloDoTop;
    private Controle controle;
    private RecyclerView rvAnimesDoTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_top);

        controle = new Controle();

        CardView cardViewRVAnimesDoTop = findViewById(R.id.cardViewRVAnimesDoTop);
        rvAnimesDoTop = findViewById(R.id.rvAnimesDoTop);

        tituloDoTop = findViewById(R.id.TituloDoTop);
        Button btnAdicionar = findViewById(R.id.btnAdicionar);
        Button btnExcluirTop = findViewById(R.id.btnExcluirTop);

        if (controle.isEdicao()) {
            getSupportActionBar().setTitle("Editar Top");

            carregarDados();
            tituloDoTop.setText(controle.getTopSendoEditado().getTituloDoTop());
            cardViewRVAnimesDoTop.setVisibility(View.VISIBLE);
            btnAdicionar.setVisibility(View.VISIBLE);
            btnExcluirTop.setVisibility(View.VISIBLE);
        }
    }

    private void carregarDados() {
        List<Anime> animes = new ArrayList<>(controle.getTopSendoEditado().getAnimesDoTop());

        AnimeRVAdapter adapter = new AnimeRVAdapter(this, animes);

        rvAnimesDoTop.setLayoutManager(new LinearLayoutManager(this));
        rvAnimesDoTop.setAdapter(adapter);
    }

    public void cadastrarTop(View view) {
        String titulo = tituloDoTop.getText().toString();

        if (controle.cadastrarTop(titulo)) {
            mostrarMensagem("Top adicionado com sucesso!");
            finish();
        }
        else {
            mostrarMensagem(controle.getErro());
        }
    }

    public void cancelarTop(View view) {
        this.finish();
    }

    public void mostrarMensagem(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }

    public void abrirTelaEscolherAnime(View view) {
        finish();
        startActivity(new Intent(this, EscolherItem.class));
    }

    public void excluirTop(View view) {
        controle.excluirTop();
        mostrarMensagem("Top Excluído com sucesso!");
        finish();
    }
}
