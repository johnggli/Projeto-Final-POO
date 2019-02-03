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
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import app.john.com.listanime.R;
import app.john.com.listanime.intermediario.Controle;

public class CadastrarAnime extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText tituloDoAnime, nomeDoDiretor, nomeDoEstudio;
    private Spinner spinnerStatus;
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

        tituloDoAnime = findViewById(R.id.txtTitulo);
        nomeDoDiretor = findViewById(R.id.txtDiretor);
        nomeDoEstudio = findViewById(R.id.txtEstudio);
    }

    public void adiconarAnime(View view) {
        String titulo = tituloDoAnime.getText().toString();
        String diretor = nomeDoDiretor.getText().toString();
        String estudio = nomeDoEstudio.getText().toString();

        controle.cadastrarAnime(titulo, diretor, estudio);

        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "selecionou " + item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
