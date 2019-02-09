package app.john.com.listanime.ui;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import app.john.com.listanime.R;

public class SplashScreen extends AppCompatActivity {

    private LinearLayout bemVindo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        bemVindo = findViewById(R.id.linearLayoutBemVindo);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.de_baixo_para_cima);

        bemVindo.startAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getBaseContext(), Login.class));
                finish();
            }
        }, 2000);
    }
}
