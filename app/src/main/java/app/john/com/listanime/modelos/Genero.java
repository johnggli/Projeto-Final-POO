package app.john.com.listanime.modelos;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Genero {
    //Atributos
    @Id
    private long id;
    private String nomeDoGenero;

    //Construtor
    public Genero(String nomeDoGenero) {
        this.nomeDoGenero = nomeDoGenero;
    }

    //Métodos de negócio

    //Métodos Get/Set
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeDoGenero() {
        return nomeDoGenero;
    }

    public void setNomeDoGenero(String nomeDoGenero) {
        this.nomeDoGenero = nomeDoGenero;
    }
}
