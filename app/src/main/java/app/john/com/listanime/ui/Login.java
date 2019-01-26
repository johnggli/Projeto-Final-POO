package app.john.com.listanime.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import app.john.com.listanime.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void abrirTelaEntrar(View view){
        final Intent intent = new Intent(this, Entrar.class);
        startActivity(intent);
    }

    public void abrirTelaCadastrar(View view){
        final Intent intent = new Intent(this, Cadastrar.class);
        startActivity(intent);
    }
}
