package app.john.com.listanime.persistencia;

import android.content.SharedPreferences;

public class UsuarioLogado {

    public static final String LOGIN = "Listanime";
    public static final long DEFAULT = -1;
    private SharedPreferences preferences;

    public UsuarioLogado(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    public void addUsuarioLogado(long id) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong("idUsuarioLogado", id);
        editor.apply();
    }

    public long getIdUsuarioLogado() {
        long id = preferences.getLong("idUsuarioLogado", DEFAULT);
        return id;
    }

    public void deletarDados() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("idUsuarioLogado");
        editor.apply();
    }

}
