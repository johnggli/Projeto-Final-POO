package app.john.com.listanime.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import app.john.com.listanime.R;
import app.john.com.listanime.intermediario.Controle;

public class Configuracoes extends AppCompatActivity {

    private EditText novoNome, novaSenha, senhaAtual;
    private Controle controle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes);

        controle = new Controle();

        novoNome = findViewById(R.id.NovoNomeDeUsuario);
        novaSenha = findViewById(R.id.NovaSenha);
        senhaAtual = findViewById(R.id.SenhaAtual);
    }

    public void salvarAlteracoes(View view) {
        String nome = novoNome.getText().toString();
        String senha = novaSenha.getText().toString();
        String atual = senhaAtual.getText().toString();

        if (controle.alterarDadosDoUsuario(nome, senha, atual)) {
            mostrarMensagem("Dados alterados com sucesso!");
            Main.getMain().finish();
            startActivity(new Intent(this, Main.class));
            finish();
        }
        else {
            mostrarMensagem(controle.getErro());
        }
    }

    public void cancelar(View view) {
        this.finish();
    }

    public void mostrarMensagem(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }
}
