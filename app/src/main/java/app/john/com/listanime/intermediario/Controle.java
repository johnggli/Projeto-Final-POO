package app.john.com.listanime.intermediario;

import app.john.com.listanime.modelos.Anime;
import app.john.com.listanime.modelos.Usuario;
import app.john.com.listanime.persistencia.App;
import io.objectbox.Box;
import io.objectbox.BoxStore;

public class Controle {
    private BoxStore boxStore = App.getApp().getBoxStore();
    private Box<Usuario> usuarioBox = boxStore.boxFor(Usuario.class);
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

    public void cadastrarAnime(String titulo, String diretor, String estudio) {
        Anime anime = new Anime(titulo, diretor, estudio);
        Usuario usuario = usuarioBox.get(idUsuarioLogado);
        usuario.animes.add(anime);
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
