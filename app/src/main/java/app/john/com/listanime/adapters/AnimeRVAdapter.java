package app.john.com.listanime.adapters;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import app.john.com.listanime.R;
import app.john.com.listanime.modelos.Anime;
import io.objectbox.relation.ToMany;

public class AnimeRVAdapter extends RecyclerView.Adapter<AnimeRVAdapter.MyViewHolder> {

    private Context context;
    private ToMany<Anime> animes;

    public AnimeRVAdapter(Context context, ToMany<Anime> animes) {
        this.context = context;
        this.animes = animes;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView nomeDoAnime;
        private TextView anoDeExibicao;
        private TextView nota;
        private TextView nomeDoEstudio;
        private LinearLayout itemDaVHolder;

        public MyViewHolder(View itemView) {
            super(itemView);

            itemDaVHolder = itemView.findViewById(R.id.anime_item);

            nomeDoAnime = itemView.findViewById(R.id.txtNomeAnime);
            anoDeExibicao = itemView.findViewById(R.id.txtAno);
            nota = itemView.findViewById(R.id.txtNota);
            nomeDoEstudio = itemView.findViewById(R.id.txtNomeEstudio);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_assistindo, viewGroup, false);

        final MyViewHolder vHolder = new MyViewHolder(view);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.nomeDoAnime.setText(animes.get(i).getTitulo());
        myViewHolder.anoDeExibicao.setText("" + animes.get(i).getAnoDeExibicao());
        myViewHolder.nota.setText("" + animes.get(i).getPontuacao());
        myViewHolder.nomeDoEstudio.setText(animes.get(i).getEstudio());

    }

    @Override
    public int getItemCount() {
        return animes.size();
    }
}
