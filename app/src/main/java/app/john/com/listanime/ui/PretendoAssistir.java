package app.john.com.listanime.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import app.john.com.listanime.R;
import app.john.com.listanime.adapters.AnimeRVAdapter;
import app.john.com.listanime.intermediario.Controle;
import app.john.com.listanime.modelos.Anime;

public class PretendoAssistir extends AppCompatActivity {

    private RecyclerView rvAnimes;
    private Controle controle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pretendo_assistir);

        controle = new Controle();

        rvAnimes = findViewById(R.id.rvPretendoAssistir);

        carregarDados();
    }

    private void carregarDados() {
        List<Anime> animes = new ArrayList<>();

        for (Anime anime: controle.getUsuarioLogado().getAnimes()) {
            if (anime.getStatus().equals("Pretendo assistir")) {
                animes.add(anime);
            }
        }

        AnimeRVAdapter adapter = new AnimeRVAdapter(this, animes);

        rvAnimes.setLayoutManager(new LinearLayoutManager(this));
        rvAnimes.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        carregarDados();
    }
}
