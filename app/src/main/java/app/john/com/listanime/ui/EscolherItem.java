package app.john.com.listanime.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import app.john.com.listanime.R;
import app.john.com.listanime.adapters.EscolherRVAdapter;
import app.john.com.listanime.intermediario.Controle;
import app.john.com.listanime.modelos.Anime;

public class EscolherItem extends AppCompatActivity {

    private RecyclerView rvAnimes;
    private Controle controle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_item);

        controle = new Controle();

        rvAnimes = findViewById(R.id.rvEscolherItem);

        carregarDados();
    }

    private void carregarDados() {

        List<Anime> animes = new ArrayList<>(controle.getUsuarioLogado().getAnimes());

        EscolherRVAdapter adapter = new EscolherRVAdapter(this, animes);

        rvAnimes.setLayoutManager(new LinearLayoutManager(this));
        rvAnimes.setAdapter(adapter);
    }
}
