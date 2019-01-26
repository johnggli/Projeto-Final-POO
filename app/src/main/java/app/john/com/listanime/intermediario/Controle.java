package app.john.com.listanime.intermediario;

import java.util.List;

import app.john.com.listanime.modelos.Usuario;
import app.john.com.listanime.persistencia.App;
import io.objectbox.Box;
import io.objectbox.BoxStore;

public class Controle {
    private BoxStore boxStore = App.getApp().getBoxStore();
    private Box<Usuario> usuarioBox = boxStore.boxFor(Usuario.class);
    private List<Usuario> usuarios;
    private Usuario usuarioLogado;

    public Controle() {
        this.usuarios = usuarioBox.getAll();
        this.usuarioLogado = null;
    }

    public boolean cadastrarUsuario(String nome, String email, String senha) {
        for (Usuario usuario : usuarios){
            if (usuario.getEmail().equals(email)){
                return false;
            }
        }
        Usuario novo_usuario = new Usuario(nome, email, senha);
        usuarioBox.put(novo_usuario);
        return true;
    }

    public boolean logar(String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                usuarioLogado = usuario;
                return true;
            }
        }
        return false;
    }
}
