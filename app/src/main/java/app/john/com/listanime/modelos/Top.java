package app.john.com.listanime.modelos;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Top {
    //Atributos
    @Id
    private long id;
    private String tituloDoTop;
    private List<Anime> animesDoTop = new ArrayList<>();

    //Construtor
    public Top(String tituloDoTop) {
        this.tituloDoTop = tituloDoTop;
    }

    //Métodos de negócio

    //Métodos Get/Set
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTituloDoTop() {
        return tituloDoTop;
    }

    public void setTituloDoTop(String tituloDoTop) {
        this.tituloDoTop = tituloDoTop;
    }

    public List<Anime> getAnimesDoTop() {
        return animesDoTop;
    }
}
