package app.john.com.listanime.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import app.john.com.listanime.R;
import app.john.com.listanime.intermediario.Controle;

public class CadastrarAnime extends AppCompatActivity {

    private EditText tituloDoAnime, nomeDoDiretor, nomeDoEstudio;
    private Controle controle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_anime);


        controle = new Controle();

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
}
