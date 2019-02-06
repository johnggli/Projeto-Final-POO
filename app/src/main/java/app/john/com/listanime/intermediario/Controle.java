package app.john.com.listanime.intermediario;

import android.widget.ImageView;

import app.john.com.listanime.modelos.Anime;
import app.john.com.listanime.modelos.Top;
import app.john.com.listanime.modelos.Usuario;
import app.john.com.listanime.persistencia.App;
import app.john.com.listanime.ui.Main;
import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.relation.ToMany;

public class Controle {
    private BoxStore boxStore = App.getApp().getBoxStore();
    private Box<Usuario> usuarioBox = boxStore.boxFor(Usuario.class);
    private Box<Anime> animeBox = boxStore.boxFor(Anime.class);
    private Box<Top> topBox = boxStore.boxFor(Top.class);
    private String erro;
    private static long idUsuarioLogado;
    private static long idDoAnimeSendoEditado;
    private static long idDoTopSendoEditado;
    private static boolean isEdicao;

    public Controle() {
    }

    public void setIdDoTopSendoEditado(Top top) {
        Controle.idDoTopSendoEditado = top.getId();
    }

    public boolean isEdicao() {
        return isEdicao;
    }

    public void setIsEdicao(boolean isEdicao) {
        Controle.isEdicao = isEdicao;
    }

    public Anime getAnimeSendoEditado() {
        return animeBox.get(idDoAnimeSendoEditado);
    }

    public Top getTopSendoEditado() {
        return topBox.get(idDoTopSendoEditado);
    }

    public long getIdDoAnimeSendoEditado() {
        return idDoAnimeSendoEditado;
    }

    public void setIdDoAnimeSendoEditado(Anime anime) {
        Controle.idDoAnimeSendoEditado = anime.getId();
    }

    public boolean cadastrarUsuario(String nome, String email, String senha) {
        // Verifica se os campos estão preenchidos.
        if ((nome.length() == 0) || (email.length() == 0) || (senha.length() == 0)) {
            erro = "Ooops! Existem campos vazios!";
            return false;
        }

        // Verifica se o email ja está cadastrado no banco de dados.
        for (Usuario usuario : usuarioBox.getAll()){
            if (usuario.getEmail().equals(email)){
                erro = "Ooops! Este endereço de e-mail ja está em uso.";
                return false;
            }
        }

        Usuario novoUsuario = new Usuario(nome, email, senha);
        usuarioBox.put(novoUsuario);
        return true;
    }

    public boolean logar(String email, String senha) {
        for (Usuario usuario: usuarioBox.getAll()) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                idUsuarioLogado = usuario.getId();
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

    public boolean cadastrarTop(String titulo) {
        if (titulo.length() == 0) {
            erro = "Ooops! Preecha o título do top.";
            return false;
        }

        Top top;

        Usuario usuario = getUsuarioLogado();

        if (isEdicao()) {
            top = getTopSendoEditado();

            top.setTituloDoTop(titulo);

            topBox.put(top);

        }
        else {
            top = new Top(titulo);
        }

        usuario.adicionarTop(top);
        usuarioBox.put(usuario);

        return true;
    }

    public boolean cadastrarAnime(String titulo, String estudio, String ano, String episodiosTotais,
                               int episodiosAssistidos, String status, String diretor, String descricao, int pontuacao, boolean favorito) {
        // Verifica se os campos obrigatórios estão preenchidos.
        if ((titulo.length() == 0) || (estudio.length() == 0) || (ano.length() == 0) || (episodiosTotais.length() == 0)) {
            erro = "Ooops! Preencha os campos obrigatórios!";
            return false;
        }

        if (Integer.parseInt(episodiosTotais) == 0) {
            erro = "Ooops! O anime deve ter pelo menos um episódio.";
            return false;
        }

        // Converte ano e episodios totais para inteiro.
        int anoDeExibicao = Integer.parseInt(ano);
        int totalDeEpisodios = Integer.parseInt(episodiosTotais);

        Anime anime;

        Usuario usuario = usuarioBox.get(idUsuarioLogado);

        if (isEdicao()) {
            anime = getAnimeSendoEditado();

            // remover o anime da lista status dele buscando ele pelo nome
            switch (anime.getStatus()) {
                case "Assistindo":
                    if (!status.equals("Assistindo")) {
                        usuario.removerAnime(anime);
                        animeBox.remove(anime.getId());
                    }
                    break;
                case "Concluído":
                    if (!status.equals("Concluído")) {
                        usuario.removerAnime(anime);
                        animeBox.remove(anime.getId());
                    }
                    break;
                case "Pretendo assistir":
                    if (!status.equals("Pretendo assistir")) {
                        usuario.removerAnime(anime);
                        animeBox.remove(anime.getId());
                    }
                    break;
                case "Descartado":
                    if (!status.equals("Descartado")) {
                        usuario.removerAnime(anime);
                        animeBox.remove(anime.getId());
                    }
                    break;
            }

            anime.setTitulo(titulo);
            anime.setEstudio(estudio);
            anime.setAnoDeExibicao(anoDeExibicao);
            anime.setEpisodiosTotais(totalDeEpisodios);
            anime.setStatus(status);
            anime.setEpisodiosAssistidos(episodiosAssistidos);
            anime.setDiretor(diretor);
            anime.setDescricao(descricao);
            anime.setPontuacao(pontuacao);
            anime.setFavorito(favorito);

            animeBox.put(anime);

        }
        else {
            anime = new Anime(titulo, estudio, status, diretor, descricao, anoDeExibicao, totalDeEpisodios, episodiosAssistidos, pontuacao, false);
        }

        usuario.adicionarAnime(anime);
        usuarioBox.put(usuario);

        return true;
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
                idUsuarioLogado = usuario.getId();
                return true;
            }
        }
        return false;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public void excluirAnime() {
        Usuario usuario = getUsuarioLogado();
        Anime anime = getAnimeSendoEditado();

        usuario.removerAnime(anime);
        animeBox.remove(anime.getId());
    }

    public int getPosicaoStatus() {
        int posicao = 0;
        switch (getAnimeSendoEditado().getStatus()) {
            case "Concluído":
                posicao = 1;
                break;
            case "Pretendo assistir":
                posicao = 2;
                break;
            case "Descartado":
                posicao = 3;
                break;
        }
        return posicao;
    }
}
