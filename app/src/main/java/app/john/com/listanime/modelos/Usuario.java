package app.john.com.listanime.modelos;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;

@Entity
public class Usuario {
    // Atributos
    @Id
    private long id;
    private String nome, email, senha;
    private ToMany<Anime> animes;
    private boolean logado;

    // Construtores
    public Usuario() {

    }

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.logado = false;
    }

    // Métodos
    public void adicionarAnime(Anime anime) {
        animes.add(anime);
    }

    public void removerAnime(Anime anime) {
        animes.remove(anime);
    }

    // Métodos Get/Set
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public boolean getLogado() {
        return this.logado;
    }

    public ToMany<Anime> getAnimes() {
        return animes;
    }
}
