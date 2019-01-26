package app.john.com.listanime.persistencia;

import android.app.Application;

import app.john.com.listanime.modelos.MyObjectBox;
import io.objectbox.BoxStore;

public class App extends Application {
    public static App sApp;

    private BoxStore boxStore;

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
        boxStore = MyObjectBox.builder().androidContext(App.this).build();
    }

    public static App getApp() {
        return sApp;
    }

    public BoxStore getBoxStore() {
        return boxStore;
    }
}
