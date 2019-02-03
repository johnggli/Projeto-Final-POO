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

    private String titulo, descricao, tipo, diretor, estudio;
    private int anoDeExibicao, pontuacao, episodiosTotais, episodiosAssistidos;
    private boolean favorito;

    //Construtores
    public Anime() {

    }

    public Anime(String titulo, String estudio, int ano, int episodiosTotais,
                 String diretor, String descricao, int pontuacao) {
        this.titulo = titulo;
        this.estudio = estudio;
        this.anoDeExibicao = ano;
        this.episodiosTotais = episodiosTotais;
        this.diretor = diretor;
        this.descricao = descricao;
        this.pontuacao = pontuacao;
        this.favorito = false;
        this.episodiosAssistidos = 0;

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

    public int getEpisodiosAssistidos() {
        return episodiosAssistidos;
    }

    public void setEpisodiosAssistidos(int episodiosAssistidos) {
        this.episodiosAssistidos = episodiosAssistidos;
    }
}
