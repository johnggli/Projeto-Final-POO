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
import app.john.com.listanime.modelos.Anotacao;
import app.john.com.listanime.modelos.Top;
import app.john.com.listanime.ui.EscreverAnotacao;
import app.john.com.listanime.ui.TelaTop;

public class AnotacaoRVAdapter extends RecyclerView.Adapter<AnotacaoRVAdapter.MyViewHolder>  {

    private Context context;
    private List<Anotacao> anotacoes;
    private Controle controle;

    public AnotacaoRVAdapter(Context context, List<Anotacao> anotacoes) {
        this.context = context;
        this.anotacoes = anotacoes;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView anotacao, data;
        private LinearLayout itemAnotacao;

        public MyViewHolder(View itemView) {
            super(itemView);

            anotacao = itemView.findViewById(R.id.txtAnotacao);
            data = itemView.findViewById(R.id.txtDataDaAnotacao);

            itemAnotacao = itemView.findViewById(R.id.anotacao_item);
        }
    }

    @NonNull
    @Override
    public AnotacaoRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_anotacao, viewGroup, false);

        final AnotacaoRVAdapter.MyViewHolder vHolder = new AnotacaoRVAdapter.MyViewHolder(view);

        controle = new Controle();

        vHolder.itemAnotacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controle.setIsEdicao(true);
                controle.setIdDaAnotacaoAtual(anotacoes.get(vHolder.getAdapterPosition()).getId());
                context.startActivity(new Intent(context, EscreverAnotacao.class));
            }
        });

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnotacaoRVAdapter.MyViewHolder myViewHolder, int i) {

        myViewHolder.anotacao.setText(anotacoes.get(i).getAnotacao());
        myViewHolder.data.setText(anotacoes.get(i).getDataDaAnotacao());

    }

    @Override
    public int getItemCount() {
        return anotacoes.size();
    }

}
