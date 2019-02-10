package app.john.com.listanime.ui;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import app.john.com.listanime.R;
import app.john.com.listanime.intermediario.Controle;

public class CadastrarAnime extends AppCompatActivity implements AdapterView.OnItemSelectedListener,
        DialogExcluir.DialogExcluirAnimeListener {

    private EditText tituloDoAnime, nomeDoEstudio, anoDeExibicao, totalDeEpisodios, nomeDoDiretor,
            descricao;
    private TextView episodiosAssistidos;
    private String status;
    private boolean favorito;
    private int nota, quantidadeDeEpisodiosAssistidos;
    private Button setFavorito, btnExcluir;
    private Controle controle;
    private Spinner spinnerStatus;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_anime);

        controle = new Controle();

        spinnerStatus = findViewById(R.id.spinnerStatus);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.animeStatus, android.R.layout.simple_spinner_item);

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

        setupDados(); // inicia os atributos.

        /* verifica se é edição de anime */
        if (controle.isEdicao()) {
            setupDadosEdicao(); // inicia os atributos em caso de edição.
        }
    }

    @SuppressLint("SetTextI18n")
    private void setupDadosEdicao() {
        getSupportActionBar().setTitle("Editar Anime");

        tituloDoAnime.setText(controle.getAnimeSendoEditado().getTitulo());
        nomeDoEstudio.setText(controle.getAnimeSendoEditado().getEstudio());
        anoDeExibicao.setText(Integer.toString(controle.getAnimeSendoEditado().getAnoDeExibicao()));
        totalDeEpisodios.setText(Integer.toString(controle.getAnimeSendoEditado().getEpisodiosTotais()));
        nomeDoDiretor.setText(controle.getAnimeSendoEditado().getDiretor());
        descricao.setText(controle.getAnimeSendoEditado().getDescricao());
        episodiosAssistidos.setText(Integer.toString(controle.getAnimeSendoEditado().getEpisodiosAssistidos()));
        ratingBar.setRating(controle.getAnimeSendoEditado().getPontuacao());
        spinnerStatus.setSelection(controle.getPosicaoStatus());
        quantidadeDeEpisodiosAssistidos = controle.getAnimeSendoEditado().getEpisodiosAssistidos();
        favorito = controle.getAnimeSendoEditado().isFavorito();

        setFavorito.setVisibility(View.VISIBLE);
        btnExcluir.setVisibility(View.VISIBLE);

        if (favorito) {
            setFavorito.setText("REMOVER DOS FAVORITOS");
        }

        setFavorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (favorito) {
                    favorito = false;
                    setFavorito.setText("ADICIONAR AOS FAVORITOS");
                }
                else {
                    favorito = true;
                    setFavorito.setText("REMOVER DOS FAVORITOS");
                }
            }
        });
    }

    private void setupDados() {
        tituloDoAnime = findViewById(R.id.txtTitulo);
        nomeDoEstudio = findViewById(R.id.txtEstudio);
        anoDeExibicao = findViewById(R.id.txtAno);
        totalDeEpisodios = findViewById(R.id.txtEpisodiosTotais);
        nomeDoDiretor = findViewById(R.id.txtDiretor);
        descricao = findViewById(R.id.txtDescricao);
        episodiosAssistidos = findViewById(R.id.txtEpisodiosAssistidos);
        setFavorito = findViewById(R.id.btnFavorito);
        btnExcluir = findViewById(R.id.btnExcluir);
        quantidadeDeEpisodiosAssistidos = 0;
    }

    public void cancelarMudancas(View view) {
        this.finish();
    }

    public void abrirDialogExcluir(View view) {
        DialogExcluir dialogExcluir = new DialogExcluir();
        dialogExcluir.show(getSupportFragmentManager(), "dialog excluir");
    }

    @SuppressLint("SetTextI18n")
    public void adiconarAnime(View view) {
        String titulo = tituloDoAnime.getText().toString();
        String estudio = nomeDoEstudio.getText().toString();
        String ano = anoDeExibicao.getText().toString();
        String episodiosTotais = totalDeEpisodios.getText().toString();

        String diretor = nomeDoDiretor.getText().toString();
        String descr = descricao.getText().toString();

        int pontuacao = nota;
        int quantidadeAssistidos = Integer.parseInt(episodiosAssistidos.getText().toString());

        if ((episodiosTotais.length() > 0) && (status.equals("Concluído"))) {
            quantidadeAssistidos = Integer.parseInt(episodiosTotais);
        }

        if (controle.cadastrarAnime(titulo, estudio, ano, episodiosTotais, quantidadeAssistidos, status,
                diretor, descr, pontuacao, favorito)) {
            if (controle.isEdicao()) {
                mostrarMensagem("Anime editado com sucesso!");
            }
            else {
                mostrarMensagem("Anime adicionado com sucesso!");
            }
            finish();
        }
        else {
            mostrarMensagem(controle.getErro());
        }
    }

    @SuppressLint("SetTextI18n")
    public void incrementar(View view) {
        if (totalDeEpisodios.length() <= 0) {
            mostrarMensagem("Informe o total de episódios.");
        }
        else {
            if (quantidadeDeEpisodiosAssistidos < Integer.parseInt(totalDeEpisodios.getText().toString())) {
                quantidadeDeEpisodiosAssistidos++;
            }
            episodiosAssistidos.setText(Integer.toString(quantidadeDeEpisodiosAssistidos));
        }
    }

    @SuppressLint("SetTextI18n")
    public void decrementar(View view) {
        if (totalDeEpisodios.length() <= 0) {
            mostrarMensagem("Informe o total de episódios.");
        }
        else {
            if (quantidadeDeEpisodiosAssistidos > 0) {
                quantidadeDeEpisodiosAssistidos--;
            }
            episodiosAssistidos.setText(Integer.toString(quantidadeDeEpisodiosAssistidos));
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        status = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void mostrarMensagem(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void excluirAnime() {
        controle.excluirAnime();
        mostrarMensagem("Anime excluído com sucesso!");
        finish();
    }
}
