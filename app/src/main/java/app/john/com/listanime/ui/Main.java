package app.john.com.listanime.ui;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;

import app.john.com.listanime.R;
import app.john.com.listanime.adapters.SectionsPagerAdapter;
import app.john.com.listanime.intermediario.Controle;

public class Main extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private SectionsPagerAdapter adapter;
    private Controle controle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.main_content);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        controle = new Controle();



        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.container);
        adapter = new SectionsPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new Assistindo(), "Watch");
        adapter.AddFragment(new Concluido(), "Completed");
        adapter.AddFragment(new Favoritos(), "Fav");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_play);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_check);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_favorite);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.main_content);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void cadastrarAnime(View view){
        final Intent intent = new Intent(this, CadastrarAnime.class);
        startActivity(intent);
    }
}
