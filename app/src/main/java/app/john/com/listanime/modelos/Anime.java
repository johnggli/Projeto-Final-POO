package app.john.com.listanime.modelos;

import android.widget.ImageView;

import java.util.List;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;

@Entity
public class Anime {
    // Atributos
    @Id
    private long id;

    private String titulo, estudio, status, diretor, descricao;
    private int anoDeExibicao, episodiosTotais, episodiosAssistidos, pontuacao;
    private ToMany<Anotacao> anotacoes;
    private boolean favorito;

    // Construtores
    public Anime() {

    }

    public Anime(String titulo, String estudio, String status, String diretor, String descricao,
                 int ano, int episodiosTotais, int episodiosAssistidos, int pontuacao, boolean favorito) {
        this.titulo = titulo;
        this.estudio = estudio;
        this.status = status;
        this.diretor = diretor;
        this.descricao = descricao;
        this.anoDeExibicao = ano;
        this.episodiosTotais = episodiosTotais;
        this.episodiosAssistidos = episodiosAssistidos;
        this.pontuacao = pontuacao;
        this.favorito = favorito;

    }

    // Métodos
    public void adicionarAnotacao(Anotacao anotacao) {
        anotacoes.add(anotacao);
    }

    public void removerAnotacao(Anotacao anotacao) {
        anotacoes.remove(anotacao);
    }

    // Métodos Get/Set
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getAnoDeExibicao() {
        return anoDeExibicao;
    }

    public void setAnoDeExibicao(int anoDeExibicao) {
        this.anoDeExibicao = anoDeExibicao;
    }

    public int getEpisodiosTotais() {
        return episodiosTotais;
    }

    public void setEpisodiosTotais(int episodiosTotais) {
        this.episodiosTotais = episodiosTotais;
    }

    public int getEpisodiosAssistidos() {
        return episodiosAssistidos;
    }

    public void setEpisodiosAssistidos(int episodiosAssistidos) {
        this.episodiosAssistidos = episodiosAssistidos;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public ToMany<Anotacao> getAnotacoes() {
        return anotacoes;
    }
}
