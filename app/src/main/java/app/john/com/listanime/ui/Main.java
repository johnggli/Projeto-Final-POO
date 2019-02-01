package app.john.com.listanime.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import app.john.com.listanime.R;
import app.john.com.listanime.adapters.SectionsPagerAdapter;
import app.john.com.listanime.intermediario.Controle;

public class Main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

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


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        controle = new Controle();



        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.container);
        adapter = new SectionsPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new Assistindo(), "Assistindo");
        adapter.AddFragment(new Concluido(), "Concluídos");
        adapter.AddFragment(new Favoritos(), "Favoritos");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_play);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_check);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_favorite);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.meusNumeros:
                startActivity(new Intent(this, MeusNumeros.class));
                break;
            case R.id.tops:
                startActivity(new Intent(this, MeusTops.class));
                break;
            case R.id.pretendoAssistir:
                startActivity(new Intent(this, PretendoAssistir.class));
                break;
            case R.id.animesDescartados:
                startActivity(new Intent(this, AnimesDescartados.class));
                break;
            case R.id.notificacoes:
                startActivity(new Intent(this, Notificacoes.class));
                break;
            case R.id.config:
                startActivity(new Intent(this, Configuracoes.class));
                break;
            case R.id.sair:
                controle.deslogar();
                startActivity(new Intent(this, Login.class));
                Toast.makeText(this, "Logout efetuado com sucesso!", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }

        DrawerLayout drawer = findViewById(R.id.main_content);
        drawer.closeDrawer(GravityCompat.START);

        return true;
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
