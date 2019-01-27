package app.john.com.listanime.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import app.john.com.listanime.R;
import app.john.com.listanime.adapters.AnimeRVAdapter;
import app.john.com.listanime.intermediario.Controle;
import app.john.com.listanime.modelos.Usuario;
import app.john.com.listanime.persistencia.App;
import io.objectbox.Box;

public class Assistindo extends Fragment {

    View view;
    private RecyclerView rvUsuarios;
    private Controle controle;
    private List<Usuario> usuarios;

    public Assistindo() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_assistindo, container, false);

        rvUsuarios = view.findViewById(R.id.rvAssistindo);
        AnimeRVAdapter adapter = new AnimeRVAdapter(getContext(), usuarios);
        rvUsuarios.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvUsuarios.setAdapter(adapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        controle = new Controle();

        usuarios = controle.getUsuarios();
    }
}
