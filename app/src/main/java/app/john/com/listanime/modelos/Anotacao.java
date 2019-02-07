package app.john.com.listanime.modelos;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Anotacao {

    @Id
    private long id;
    private String anotacao;
    private String dataDaAnotacao;

    public Anotacao() {

    }

    public Anotacao(String texto, String data) {
        anotacao = texto;
        dataDaAnotacao = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(String anotacao) {
        this.anotacao = anotacao;
    }

    public String getDataDaAnotacao() {
        return dataDaAnotacao;
    }

    public void setDataDaAnotacao(String dataDaAnotacao) {
        this.dataDaAnotacao = dataDaAnotacao;
    }
}
