package app.john.com.listanime.adapters;

import android.annotation.SuppressLint;
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

import java.util.List;

import app.john.com.listanime.R;
import app.john.com.listanime.intermediario.Controle;
import app.john.com.listanime.modelos.Anime;
import app.john.com.listanime.ui.Anotacoes;
import app.john.com.listanime.ui.CadastrarAnime;

public class AnimeRVAdapter extends RecyclerView.Adapter<AnimeRVAdapter.MyViewHolder> {

    /* Atributos */
    private Context context;
    private Controle controle;
    private Dialog myDialog;
    private List<Anime> animes;

    /* Construtor */
    public AnimeRVAdapter(Context context, List<Anime> animes) {
        this.context = context;
        this.animes = animes;
    }

    /* Classe ViewHolver */
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        /* Atributos */
        private ImageView img_status, iconeFavoritado;
        private LinearLayout itemAnime;
        private ProgressBar progressBar;
        private TextView nomeDoAnime, nomeDoEstudio, anoDeExibicao, episodiosAssistidos,
                episodiosTotais, nota;

        /* Construtor */
        public MyViewHolder(View itemView) {
            super(itemView);

            /* Binding */
            setupViews();
        }

        private void setupViews() {
            img_status = itemView.findViewById(R.id.img_status);
            iconeFavoritado = itemView.findViewById(R.id.iconeFavoritado);

            itemAnime = itemView.findViewById(R.id.anime_item);

            progressBar = itemView.findViewById(R.id.barraDeProgresso);

            nomeDoAnime = itemView.findViewById(R.id.txtNomeAnime);
            nomeDoEstudio = itemView.findViewById(R.id.txtNomeEstudio);
            anoDeExibicao = itemView.findViewById(R.id.txtAno);
            episodiosAssistidos = itemView.findViewById(R.id.episodiosAssistidos);
            episodiosTotais = itemView.findViewById(R.id.episodiosTotais);
            nota = itemView.findViewById(R.id.txtNota);
        }
    }

    /* Métodos */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_assistindo, viewGroup, false);

        final MyViewHolder vHolder = new MyViewHolder(view);

        /* inicia controle */
        controle = new Controle();

        /* iniciando dialog */
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.dialog_anime);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        /* onClick */
        vHolder.itemAnime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* variáveis */
                TextView dialogNomeAnime = myDialog.findViewById(R.id.dialogNomeAnime);
                TextView dialogEstudio = myDialog.findViewById(R.id.dialogEstudio);
                TextView dialogBotaoEditar = myDialog.findViewById(R.id.dialogBotaoEditar);
                TextView dialogBotaoAnotacoes = myDialog.findViewById(R.id.dialogBotaoAnotacoes);

                /* setting dialog */
                dialogNomeAnime.setText(animes.get(vHolder.getAdapterPosition()).getTitulo());
                dialogEstudio.setText(animes.get(vHolder.getAdapterPosition()).getEstudio());

                /* setting id do usuário logado em controle */
                controle.setIdDoAnimeSendoEditado(animes.get(vHolder.getAdapterPosition()));

                /* onClick dos botões da dialog */
                dialogBotaoEditar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editarAnime();
                    }
                });

                dialogBotaoAnotacoes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        adicionarAnotacao();
                    }
                });

                /* abrir dialog */
                myDialog.show();
            }
        });

        return vHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        /* setting ViewHolder */
        myViewHolder.nomeDoAnime.setText(animes.get(i).getTitulo());
        myViewHolder.nomeDoEstudio.setText(animes.get(i).getEstudio());
        myViewHolder.anoDeExibicao.setText(Integer.toString(animes.get(i).getAnoDeExibicao()));
        myViewHolder.episodiosAssistidos.setText(Integer.toString(animes.get(i).getEpisodiosAssistidos()));
        myViewHolder.episodiosTotais.setText(Integer.toString(animes.get(i).getEpisodiosTotais()));
        myViewHolder.nota.setText(Integer.toString(animes.get(i).getPontuacao()));

        switch (animes.get(i).getStatus()) {
            case "Concluído":
                myViewHolder.img_status.setImageResource(R.mipmap.icone_concluido);
                break;
            case "Pretendo assistir":
                myViewHolder.img_status.setImageResource(R.mipmap.icone_pretendo_assistir);
                break;
            case "Descartado":
                myViewHolder.img_status.setImageResource(R.mipmap.icone_descartado);
                break;
        }

        if (animes.get(i).isFavorito()) {
            myViewHolder.iconeFavoritado.setVisibility(View.VISIBLE);
        }

        int valor = animes.get(i).getEpisodiosAssistidos() * 100 / animes.get(i).getEpisodiosTotais();
        myViewHolder.progressBar.setProgress(valor);
    }

    @Override
    public int getItemCount() {
        return animes.size();
    }

    private void editarAnime() {
        myDialog.dismiss();
        controle.setIsEdicao(true); // avisa ao controle que se trata de uma edição
        context.startActivity(new Intent(context, CadastrarAnime.class));
    }

    private void adicionarAnotacao() {
        myDialog.dismiss();
        context.startActivity(new Intent(context, Anotacoes.class));
    }
}
