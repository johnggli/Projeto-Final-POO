package app.john.com.listanime.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import app.john.com.listanime.R;
import app.john.com.listanime.intermediario.Controle;
import app.john.com.listanime.modelos.Top;
import app.john.com.listanime.ui.TelaTop;

public class TopRVAdapter extends RecyclerView.Adapter<TopRVAdapter.MyViewHolder>  {
    /* Atributos */
    private Context context;
    private Controle controle;
    private List<Top> tops;

    /* Construtor */
    public TopRVAdapter(Context context, List<Top> tops) {
        this.context = context;
        this.tops = tops;
    }

    /* Classe viewHolder */
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tituloDoTop;
        private LinearLayout itemTop;

        public MyViewHolder(View itemView) {
            super(itemView);

            /* binding */
            setupViews();
        }

        private void setupViews() {
            tituloDoTop = itemView.findViewById(R.id.txtTituloDoTop);

            itemTop = itemView.findViewById(R.id.top_item);
        }
    }

    @NonNull
    @Override
    public TopRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_top, viewGroup, false);

        final TopRVAdapter.MyViewHolder vHolder = new TopRVAdapter.MyViewHolder(view);

        controle = new Controle();

        vHolder.itemTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controle.setIdDoTopSendoEditado(tops.get(vHolder.getAdapterPosition()));
                controle.setIsEdicao(true);

                context.startActivity(new Intent(context, TelaTop.class));
            }
        });

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TopRVAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.tituloDoTop.setText(tops.get(i).getTituloDoTop());
    }

    @Override
    public int getItemCount() {
        return tops.size();
    }
}
