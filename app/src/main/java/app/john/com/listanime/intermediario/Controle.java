package app.john.com.listanime.intermediario;

import android.widget.ImageView;

import app.john.com.listanime.modelos.Anime;
import app.john.com.listanime.modelos.Usuario;
import app.john.com.listanime.persistencia.App;
import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.relation.ToMany;

public class Controle {
    private BoxStore boxStore = App.getApp().getBoxStore();
    private Box<Usuario> usuarioBox = boxStore.boxFor(Usuario.class);
    private Box<Anime> animeBox = boxStore.boxFor(Anime.class);
    private String erro;
    private static long idUsuarioLogado;
    private static long idDoAnimeSendoEditado;
    private static boolean ehEdicao;

    public Controle() {
    }

    public Anime getAnimeSendoEditado() {
        Anime anime = animeBox.get(idDoAnimeSendoEditado);
        return anime;
    }

    public boolean isEhEdicao() {
        return ehEdicao;
    }

    public void setEhEdicao(boolean ehEdicao) {
        Controle.ehEdicao = ehEdicao;
    }

    public long getIdDoAnimeSendoEditado() {
        return idDoAnimeSendoEditado;
    }

    public void setIdDoAnimeSendoEditado(Anime anime) {
        Controle.idDoAnimeSendoEditado = anime.id;
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

    public boolean cadastrarAnime(String titulo, String estudio, String ano, String episodiosTotais,
                               int episodiosAssistidos, String status, String diretor, String descricao, int pontuacao) {
        // Verifica se os campos obrigatórios estão preenchidos.
        if ((titulo.length() == 0) || (estudio.length() == 0) || (ano.length() == 0) || (episodiosTotais.length() == 0)) {
            erro = "Ooops! Preencha os campos obrigatórios!";
            return false;
        }

        // Converte ano e episodios totais para inteiro.
        int anoDeExibicao = Integer.parseInt(ano);
        int totalDeEpisodios = Integer.parseInt(episodiosTotais);

        Anime anime;

        Usuario usuario = usuarioBox.get(idUsuarioLogado);

        if (isEhEdicao()) {
            anime = getAnimeSendoEditado();

            // remover o anime da lista status dele buscando ele pelo nome
            if (contemAnimeNaLista(usuario.animesAssistindo)) {
                if (status.equals("Assistindo")) {
                    status = "StatusNaoAlterado";
                }
                else {
                    usuario.animesAssistindo.remove(anime);
                    animeBox.remove(anime.id);
                }
            }
            else if (contemAnimeNaLista(usuario.animesConcluidos)) {
                if (status.equals("Concluído")) {
                    status = "StatusNaoAlterado";
                }
                else {
                    usuario.animesConcluidos.remove(anime);
                    animeBox.remove(anime.id);
                }
            }
            else if (contemAnimeNaLista(usuario.animesPretendoAssistir)) {
                if (status.equals("Pretendo assistir")) {
                    status = "StatusNaoAlterado";
                }
                else {
                    usuario.animesPretendoAssistir.remove(anime);
                    animeBox.remove(anime.id);
                }
            }
            else if (contemAnimeNaLista(usuario.animesDescartados)) {
                if (status.equals("Descartado")) {
                    status = "StatusNaoAlterado";
                }
                else {
                    usuario.animesDescartados.remove(anime);
                    animeBox.remove(anime.id);
                }
            }

            anime.setTitulo(titulo);
            anime.setEstudio(estudio);
            anime.setAnoDeExibicao(anoDeExibicao);
            anime.setEpisodiosTotais(totalDeEpisodios);
            anime.setEpisodiosAssistidos(episodiosAssistidos);
            anime.setDiretor(diretor);
            anime.setDescricao(descricao);
            anime.setPontuacao(pontuacao);

            // anime.getStatus.equals(status)...

            animeBox.put(anime);

//            if (anime.getStatus != status) {
//                if (getStatus.equals("Assistindo")) {
//                    usuario.animesAssistindo.remove(anime);
//                }
//                else if (getStatus.equals("Concluído")) {
//                    usuario.animesConcluidos.add(anime);
//                }
//                else if (getStatus.equals("Pretendo assistir")) {
//                    usuario.animesPretendoAssistir.add(anime);
//                }
//                else if (getStatus.equals("Descartado")) {
//                    usuario.animesDescartados.add(anime);
//                }
//            }

        }
        else {
            anime = new Anime(titulo, estudio, anoDeExibicao, totalDeEpisodios, episodiosAssistidos, diretor, descricao, pontuacao);
        }

        switch (status) {
            case "Assistindo":
                usuario.animesAssistindo.add(anime);
                break;
            case "Concluído":
                usuario.animesConcluidos.add(anime);
                break;
            case "Pretendo assistir":
                usuario.animesPretendoAssistir.add(anime);
                break;
            case "Descartado":
                usuario.animesDescartados.add(anime);
                break;
        }
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
                idUsuarioLogado = usuario.id;
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

    public boolean contemAnimeNaLista(ToMany<Anime> lista) {
        for (Anime anime: lista) {
            if (anime.getTitulo().equals(getAnimeSendoEditado().getTitulo())) {
                return true;
            }
        }
        return false;
    }
}
