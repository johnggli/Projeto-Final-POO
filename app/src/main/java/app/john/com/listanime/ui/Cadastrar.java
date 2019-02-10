package app.john.com.listanime.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import app.john.com.listanime.R;
import app.john.com.listanime.intermediario.Controle;

public class Cadastrar extends AppCompatActivity {

    private EditText txtNome, txtEmail, txtSenha;
    private Controle controle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        /* Inicia controle */
        controle = new Controle();

        txtNome = findViewById(R.id.txtNome);
        txtEmail = findViewById(R.id.txtEmail);
        txtSenha = findViewById(R.id.txtSenha);
    }

    public void concluirCadastro(View view) {
        /* Obtém os valores digitados */
        String nome = txtNome.getText().toString();
        String email = txtEmail.getText().toString();
        String senha = txtSenha.getText().toString();

        /* Cadastra o usuário */
        if (controle.cadastrarUsuario(nome, email, senha)) {
            mostrarMensagem("Usuário cadastrado com sucesso!");
            controle.logar(email, senha);
            startActivity(new Intent(this, Main.class));
            finish();
        }
        else {
            mostrarMensagem(controle.getErro());
        }
    }

    public void mostrarMensagem (String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, Login.class));
        finish();
    }
}
