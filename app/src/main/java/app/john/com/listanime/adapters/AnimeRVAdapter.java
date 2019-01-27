package app.john.com.listanime.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import app.john.com.listanime.R;
import app.john.com.listanime.modelos.Usuario;
import io.objectbox.Box;

public class AnimeRVAdapter extends RecyclerView.Adapter<AnimeRVAdapter.MyViewHolder> {

    private Context context;
    private List<Usuario> usuarios;

    public AnimeRVAdapter(Context context, List<Usuario> usuarios) {
        this.context = context;
        this.usuarios = usuarios;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView nomeDoAnime;

        public MyViewHolder(View itemView) {
            super(itemView);

            nomeDoAnime = itemView.findViewById(R.id.txtNomeAnime);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_assistindo, viewGroup, false);
        MyViewHolder vHolder = new MyViewHolder(view);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.nomeDoAnime.setText(usuarios.get(i).getNome());

    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }
}
