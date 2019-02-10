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

public class Entrar extends AppCompatActivity {

    private EditText txtEmail, txtSenha;
    private Controle controle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrar);

        controle = new Controle();

        txtEmail = findViewById(R.id.txtEmail);
        txtSenha = findViewById(R.id.txtSenha);
    }

    public void continuar(View view) {
        String email = txtEmail.getText().toString();
        String senha = txtSenha.getText().toString();

        if (controle.logar(email, senha)) {
            startActivity(new Intent(this, Main.class));
            finish();
        }
        else {
            mensagem("Ooops! E-mail ou senha inválidos.");
        }
    }

    public void mensagem (String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, Login.class));
        finish();
    }
}
