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
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import app.john.com.listanime.R;
import app.john.com.listanime.intermediario.Controle;
import app.john.com.listanime.modelos.Anime;
import app.john.com.listanime.ui.CadastrarAnime;
import app.john.com.listanime.ui.Login;
import io.objectbox.relation.ToMany;

public class AnimeRVAdapter extends RecyclerView.Adapter<AnimeRVAdapter.MyViewHolder> {

    private Context context;
    private ToMany<Anime> animes;
    private Dialog myDialog;
    private Controle controle;

    public AnimeRVAdapter(Context context, ToMany<Anime> animes) {
        this.context = context;
        this.animes = animes;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView nomeDoAnime;
        private TextView nomeDoEstudio;
        private TextView anoDeExibicao;
        private TextView episodiosAssistidos;
        private TextView episodiosTotais;
        private TextView nota;
        private ProgressBar progressBar;
        private LinearLayout itemAnime;

        public MyViewHolder(View itemView) {
            super(itemView);

            nomeDoAnime = itemView.findViewById(R.id.txtNomeAnime);
            nomeDoEstudio = itemView.findViewById(R.id.txtNomeEstudio);
            anoDeExibicao = itemView.findViewById(R.id.txtAno);
            episodiosAssistidos = itemView.findViewById(R.id.episodiosAssistidos);
            episodiosTotais = itemView.findViewById(R.id.episodiosTotais);
            nota = itemView.findViewById(R.id.txtNota);

            progressBar = itemView.findViewById(R.id.barraDeProgresso);

            itemAnime = itemView.findViewById(R.id.anime_item);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_assistindo, viewGroup, false);

        final MyViewHolder vHolder = new MyViewHolder(view);

        controle = new Controle();

        // Iniciando Dialog.
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.dialog_anime);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        vHolder.itemAnime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dialogNomeAnime = myDialog.findViewById(R.id.dialogNomeAnime);
                TextView dialogEstudio = myDialog.findViewById(R.id.dialogEstudio);
                TextView dialogBotaoEditar = myDialog.findViewById(R.id.dialogBotaoEditar);
                dialogNomeAnime.setText(animes.get(vHolder.getAdapterPosition()).getTitulo());
                dialogEstudio.setText(animes.get(vHolder.getAdapterPosition()).getEstudio());

                controle.setIdDoAnimeSendoEditado(animes.get(vHolder.getAdapterPosition()));

                dialogBotaoEditar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editarAnime();
                    }
                });

                myDialog.show();
            }
        });

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.nomeDoAnime.setText(animes.get(i).getTitulo());
        myViewHolder.nomeDoEstudio.setText(animes.get(i).getEstudio());
        myViewHolder.anoDeExibicao.setText("" + animes.get(i).getAnoDeExibicao());
        myViewHolder.episodiosAssistidos.setText("" + animes.get(i).getEpisodiosAssistidos());
        myViewHolder.episodiosTotais.setText("" + animes.get(i).getEpisodiosTotais());
        myViewHolder.nota.setText("" + animes.get(i).getPontuacao());

        int valor = animes.get(i).getEpisodiosAssistidos() * 100 / animes.get(i).getEpisodiosTotais();
        myViewHolder.progressBar.setProgress(valor);

    }

    @Override
    public int getItemCount() {
        return animes.size();
    }

    public void editarAnime() {
        // Toast.makeText(context, "" + controle.getIdDoAnimeSendoEditado(), Toast.LENGTH_SHORT).show();
        myDialog.dismiss();
        controle.setIsEdicao(true);
        context.startActivity(new Intent(context, CadastrarAnime.class));
    }
}
