package app.john.com.listanime.modelos;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;

@Entity
public class Top {
    /* Atributos */
    @Id
    private long id;
    private String tituloDoTop;
    private ToMany<Anime> animesDoTop;

    /* Construtores */
    public Top() {

    }

    public Top(String tituloDoTop) {
        this.tituloDoTop = tituloDoTop;
    }

    /* Métodos */
    public void adicionarAnimeAoTop(Anime anime) {
        animesDoTop.add(anime);
    }

    public void removerAnimeDoTop(Anime anime) {
        animesDoTop.remove(anime);
    }

    /* Métodos Get/Set */
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

    public ToMany<Anime> getAnimesDoTop() {
        return animesDoTop;
    }
}
