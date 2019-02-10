package app.john.com.listanime.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import app.john.com.listanime.R;
import app.john.com.listanime.adapters.TopRVAdapter;
import app.john.com.listanime.intermediario.Controle;
import app.john.com.listanime.modelos.Top;

public class MeusTops extends AppCompatActivity {

    private RecyclerView rvTops;
    private Controle controle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_tops);

        controle = new Controle();

        rvTops = findViewById(R.id.rvMeusTops);

        carregarDados();
    }

    private void carregarDados() {
        List<Top> tops = new ArrayList<>(controle.getUsuarioLogado().getTops());

        TopRVAdapter adapter = new TopRVAdapter(this, tops);

        rvTops.setLayoutManager(new LinearLayoutManager(this));
        rvTops.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarDados();
    }

    public void novoTop(View view){
        controle.setIsEdicao(false);
        startActivity(new Intent(this, TelaTop.class));
    }
}
