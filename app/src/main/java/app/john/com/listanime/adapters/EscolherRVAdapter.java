package app.john.com.listanime.adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import app.john.com.listanime.R;
import app.john.com.listanime.intermediario.Controle;
import app.john.com.listanime.modelos.Anime;
import app.john.com.listanime.modelos.Top;
import app.john.com.listanime.ui.EscolherItem;
import app.john.com.listanime.ui.TelaTop;

public class EscolherRVAdapter extends RecyclerView.Adapter<EscolherRVAdapter.MyViewHolder>  {

    private Context context;
    private List<Anime> animes;
    private Controle controle;

    public EscolherRVAdapter(Context context, List<Anime> animes) {
        this.context = context;
        this.animes = animes;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tituloDoAnime;
        private LinearLayout itemAnime;

        public MyViewHolder(View itemView) {
            super(itemView);

            tituloDoAnime = itemView.findViewById(R.id.txtTituloDoAnime);

            itemAnime = itemView.findViewById(R.id.escolher_item);
        }
    }

    @NonNull
    @Override
    public EscolherRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_escolher, viewGroup, false);

        final EscolherRVAdapter.MyViewHolder vHolder = new EscolherRVAdapter.MyViewHolder(view);

        controle = new Controle();

        vHolder.itemAnime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // textview e buttons here
                controle.adicionarAnimeAoTop(animes.get(vHolder.getAdapterPosition()));
                mostrarMensagem(animes.get(vHolder.getAdapterPosition()).getTitulo() + " adicionado!");

                // finaliza a tela escolher anime.
                context.startActivity(new Intent(context, TelaTop.class));
                ((EscolherItem)context).finish();
            }
        });

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EscolherRVAdapter.MyViewHolder myViewHolder, int i) {

        myViewHolder.tituloDoAnime.setText(animes.get(i).getTitulo());

    }

    @Override
    public int getItemCount() {
        return animes.size();
    }

    public void mostrarMensagem(String mensagem) {
        Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();
    }

}
