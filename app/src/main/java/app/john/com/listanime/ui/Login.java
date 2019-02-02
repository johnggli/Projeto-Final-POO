package app.john.com.listanime.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import app.john.com.listanime.R;
import app.john.com.listanime.intermediario.Controle;

public class Login extends AppCompatActivity {

    private Controle controle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        controle = new Controle();

        if (controle.temUsuarioLogado()) {
            startActivity(new Intent(this, Main.class));
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (controle.temUsuarioLogado()) {
            finish();
        }
    }

    public void abrirTelaEntrar(View view){
        startActivity(new Intent(this, Entrar.class));
    }

    public void abrirTelaCadastrar(View view){
        startActivity(new Intent(this, Cadastrar.class));
    }
}
