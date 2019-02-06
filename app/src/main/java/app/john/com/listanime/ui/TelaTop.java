package app.john.com.listanime.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import app.john.com.listanime.R;
import app.john.com.listanime.intermediario.Controle;

public class TelaTop extends AppCompatActivity {

    private EditText tituloDoTop;
    private Controle controle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_top);

        controle = new Controle();

        tituloDoTop = findViewById(R.id.TituloDoTop);

        if (controle.isEdicao()) {
            getSupportActionBar().setTitle("Editar Top");

            tituloDoTop.setText(controle.getTopSendoEditado().getTituloDoTop());
        }
    }

    public void adicionarTop(View view) {
        String titulo = tituloDoTop.getText().toString();

        if (controle.cadastrarTop(titulo)) {
            mostrarMensagem("Top adicionado com sucesso!");
            finish();
        }
        else {
            mostrarMensagem(controle.getErro());
        }
    }

    public void cancelarTop(View view) {
        this.finish();
    }

    public void mostrarMensagem(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }
}
