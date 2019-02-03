package app.john.com.listanime.modelos;

import android.widget.ImageView;

import java.util.List;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;

@Entity
public class Anime {
    //Atributos
    @Id
    public long id;

    private String titulo, descricao, tipo, diretor, estudio, status;
    private int anoDeExibicao, pontuacao, episodiosTotais;
    private ToMany<Episodio> episodios;
    private ToMany<Genero> generos;
    private boolean favorito;

    //Construtores
    public Anime() {

    }

    public Anime(String titulo, String estudio, int ano, int episodiosTotais, String status,
                 String diretor, String descricao, int pontuacao) {
        this.titulo = titulo;
        this.estudio = estudio;
        this.anoDeExibicao = ano;
        this.episodiosTotais = episodiosTotais;
        this.status = status;
        this.diretor = diretor;
        this.descricao = descricao;
        this.pontuacao = pontuacao;
        this.favorito = false;

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

    public int getAnoDeExibicao() {
        return anoDeExibicao;
    }

    public void setAnoDeExibicao(int anoDeExibicao) {
        this.anoDeExibicao = anoDeExibicao;
    }
}
