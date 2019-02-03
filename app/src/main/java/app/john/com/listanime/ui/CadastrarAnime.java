package app.john.com.listanime.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import app.john.com.listanime.R;
import app.john.com.listanime.intermediario.Controle;

public class CadastrarAnime extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText tituloDoAnime, nomeDoEstudio, anoDeExibicao, totalDeEpisodios, nomeDoDiretor, descricao;
    private String status;
    private int nota;
    private Spinner spinnerStatus;
    private RatingBar ratingBar;
    private Controle controle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_anime);

        controle = new Controle();

        spinnerStatus = findViewById(R.id.spinnerStatus);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.animeStatus, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerStatus.setAdapter(adapter);

        spinnerStatus.setOnItemSelectedListener(this);

        ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                nota = (int) rating;
            }
        });

        tituloDoAnime = findViewById(R.id.txtTitulo);
        nomeDoEstudio = findViewById(R.id.txtEstudio);
        anoDeExibicao = findViewById(R.id.txtAno);
        totalDeEpisodios = findViewById(R.id.txtEpisodiosTotais);
        nomeDoDiretor = findViewById(R.id.txtDiretor);
        descricao = findViewById(R.id.txtDescricao);
    }

    public void adiconarAnime(View view) {
        String titulo = tituloDoAnime.getText().toString();
        String estudio = nomeDoEstudio.getText().toString();
        int ano = Integer.parseInt(anoDeExibicao.getText().toString());
        int episodiosTotais = Integer.parseInt(totalDeEpisodios.getText().toString());
        String diretor = nomeDoDiretor.getText().toString();
        String descr = descricao.getText().toString();
        int pontuacao = nota;

        controle.cadastrarAnime(titulo, estudio, ano, episodiosTotais, status, diretor, descr, pontuacao);

        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        status = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
