package app.john.com.listanime.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.john.com.listanime.R;
import app.john.com.listanime.intermediario.Controle;

public class EscreverAnotacao extends AppCompatActivity {

    private EditText anotacao;
    private Controle controle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escrever_anotacao);

        controle = new Controle();

        anotacao = findViewById(R.id.Anotacao);
        Button btnRemover = findViewById(R.id.btnRemover);

        if (controle.isEdicao()) {
            getSupportActionBar().setTitle("Editar Anotação");
            anotacao.setText(controle.getAnotacaoAtual().getAnotacao());

            btnRemover.setVisibility(View.VISIBLE);
        }
    }

    public void botaoOk(View view) {
        String texto = anotacao.getText().toString();

        if (controle.adicionarAnotacao(texto)) {
            mostrarMensagem("Anotação adicionada com sucesso!");
            finish();
        }
        else {
            mostrarMensagem(controle.getErro());
        }
    }

    public void botaoRemover(View view) {
        controle.removerAnotacao();
        mostrarMensagem("Anotação removida com sucesso!");
        finish();
    }

    public void mostrarMensagem(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }
}
