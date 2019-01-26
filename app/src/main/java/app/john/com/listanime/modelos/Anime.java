package app.john.com.listanime.modelos;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Anime {
    //Atributos
    @Id
    private long id;
    private String titulo, descricao, tipo, diretor, estudio, status;
    private int anoDePublicacao, pontuacao, episodiosTotais;
    private List<Episodio> episodios = new ArrayList<>();
    private List<Genero> generos = new ArrayList<>();
    private boolean favorito = false;

    //Construtor
    public Anime(String titulo, String descricao, String tipo, String diretor, String estudio,
                 String status, int anoDePublicacao, int pontuacao, int episodiosTotais) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.diretor = diretor;
        this.estudio = estudio;
        this.status = status;
        this.anoDePublicacao = anoDePublicacao;
        this.pontuacao = pontuacao;
        this.episodiosTotais = episodiosTotais;
    }

    //Métodos de Negócio

    //Métodos Get/Set
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public void setAnoDePublicacao(int anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getEpisodiosTotais() {
        return episodiosTotais;
    }

    public void setEpisodiosTotais(int episodiosTotais) {
        this.episodiosTotais = episodiosTotais;
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
