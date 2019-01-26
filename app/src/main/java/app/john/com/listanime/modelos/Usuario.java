package app.john.com.listanime.modelos;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Usuario {
    //Atributos
    @Id
    private long id;
    private String nome, senha;
    private List<Anime> animes = new ArrayList<>();

    //Construtor
    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    //Métodos de negócio

    //Métodos Get/Set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Anime> getAnimes() {
        return animes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
