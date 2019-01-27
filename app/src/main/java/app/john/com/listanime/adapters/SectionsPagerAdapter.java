package app.john.com.listanime.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> lstFragment = new ArrayList<>();
    private final List<String> lstTitulos = new ArrayList<>();

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

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

    //    public SectionsPagerAdapter(FragmentManager fm) {
//        super(fm);
//    }
//
//    @Override
//    public Fragment getItem(int position) {
//        // getItem is called to instantiate the fragment for the given page.
//        // Return a PlaceholderFragment (defined as a static inner class below).
//        // return PlaceholderFragment.newInstance(position + 1);
//        Fragment fragment = null;
//        switch (position) {
//            case 0:
//                fragment = new Assistindo();
//                break;
//            case 1:
//                fragment = new Concluido();
//                break;
//            case 2:
//                fragment = new Favoritos();
//                break;
//        }
//        return fragment;
//    }
//
//    @Override
//    public int getCount() {
//        // Show 3 total pages.
//        return 3;
//    }
//
//    @Override
//    public CharSequence getPageTitle(int position) {
//        switch (position) {
//            case 0:
//                return "ASSISTINDO";
//            case 1:
//                return "CONCLUÍDO";
//            case 2:
//                return "FAVORITOS";
//        }
//        return null;
//    }
}
