package app.john.com.listanime.modelos;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Episodio {
    //Atributos
    @Id
    private long id;
    private String titulo, resenha;
    private int nota;

    //Construtor
    public Episodio(String titulo, String resenha, int nota) {
        this.titulo = titulo;
        this.resenha = resenha;
        this.nota = nota;
    }

    //Métodos de negócio

    //Métodos Get/Set
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResenha() {
        return resenha;
    }

    public void setResenha(String resenha) {
        this.resenha = resenha;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
