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
import app.john.com.listanime.adapters.AnotacaoRVAdapter;
import app.john.com.listanime.intermediario.Controle;
import app.john.com.listanime.modelos.Anotacao;

public class Anotacoes extends AppCompatActivity {

    private RecyclerView rvAnotacoes;
    private Controle controle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anotacoes);

        controle = new Controle();

        rvAnotacoes = findViewById(R.id.rvAnotacoes);

        carregarDados();
    }

    private void carregarDados() {
        List<Anotacao> anotacoes = new ArrayList<>(controle.getAnimeSendoEditado().getAnotacoes());

        AnotacaoRVAdapter adapter = new AnotacaoRVAdapter(this, anotacoes);

        rvAnotacoes.setLayoutManager(new LinearLayoutManager(this));
        rvAnotacoes.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarDados();
    }

    public void adicionarAnotacao(View view) {
        controle.setIsEdicao(false);
        startActivity(new Intent(this, EscreverAnotacao.class));
    }
}
