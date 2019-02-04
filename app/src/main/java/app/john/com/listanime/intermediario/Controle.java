package app.john.com.listanime.intermediario;

import android.widget.ImageView;

import app.john.com.listanime.modelos.Anime;
import app.john.com.listanime.modelos.Usuario;
import app.john.com.listanime.persistencia.App;
import io.objectbox.Box;
import io.objectbox.BoxStore;

public class Controle {
    private BoxStore boxStore = App.getApp().getBoxStore();
    private Box<Usuario> usuarioBox = boxStore.boxFor(Usuario.class);
    private Box<Anime> animeBox = boxStore.boxFor(Anime.class);
    private static long idUsuarioLogado;

    public Controle() {
    }

    public boolean cadastrarUsuario(String nome, String email, String senha) {
        for (Usuario usuario : usuarioBox.getAll()){
            if (usuario.getEmail().equals(email)){
                return false;
            }
        }
        Usuario novo_usuario = new Usuario(nome, email, senha);
        usuarioBox.put(novo_usuario);
        return true;
    }

    public boolean logar(String email, String senha) {
        for (Usuario usuario: usuarioBox.getAll()) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                idUsuarioLogado = usuario.id;

                logarUsuario();

                return true;
            }
        }
        return false;
    }

    public void logarUsuario() {
        Usuario usuario = usuarioBox.get(idUsuarioLogado);
        usuario.setLogado(true);
        usuarioBox.put(usuario);
    }

    public void cadastrarAnime(String titulo, String estudio, int ano, int episodiosTotais,
                               int episodiosAssistidos, String status, String diretor, String descricao, int pontuacao) {
        Anime anime = new Anime(titulo, estudio, ano, episodiosTotais, episodiosAssistidos, diretor, descricao, pontuacao);

        Usuario usuario = usuarioBox.get(idUsuarioLogado);

        if (status.equals("Assistindo")) {
            usuario.animesAssistindo.add(anime);
        }
        else if (status.equals("Concluído")) {
            usuario.animesConcluidos.add(anime);
        }
        else if (status.equals("Pretendo assistir")) {
            usuario.animesPretendoAssistir.add(anime);
        }
        else if (status.equals("Descartado")) {
            usuario.animesDescartados.add(anime);
        }
        usuarioBox.put(usuario);
    }

    public Usuario getUsuarioLogado() {
        return usuarioBox.get(idUsuarioLogado);
    }

    public void deslogar() {
        Usuario usuario = usuarioBox.get(idUsuarioLogado);
        usuario.setLogado(false);
        usuarioBox.put(usuario);
    }

    public boolean temUsuarioLogado() {
        for (Usuario usuario: usuarioBox.getAll()) {
            if (usuario.getLogado()) {
                idUsuarioLogado = usuario.id;
                return true;
            }
        }
        return false;
    }
}
