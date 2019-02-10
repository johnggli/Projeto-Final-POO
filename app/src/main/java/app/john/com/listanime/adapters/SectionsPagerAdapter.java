package app.john.com.listanime.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    /* Atributos */
    private final List<Fragment> lstFragment = new ArrayList<>();
    private final List<String> lstTitulos = new ArrayList<>();

    /* Construtor */
    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /* Métodos */
    @Override
    public Fragment getItem(int position) {
        return lstFragment.get(position);
    }

    @Override
    public int getCount() {
        return lstTitulos.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return lstTitulos.get(position);
    }

    public void AddFragment(Fragment fragment, String titulo) {
        lstFragment.add(fragment);
        lstTitulos.add(titulo);
    }
}
