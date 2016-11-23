package test.avick.com.animatedtab.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.HashMap;

import test.avick.com.animatedtab.Fragment.DummyFragment;

/**
 * Created by avick on 11/23/16.
 */

public class DummyAdapter extends FragmentStatePagerAdapter {

    int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "                          Tab1                              ", "                 Tab2                   ", "                  Tab3                                          " };
    private HashMap<Integer, Fragment> fragmentHashMap;// = new HashMap<>();

    public DummyAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        fragmentHashMap = new HashMap<>(3);
    }

    @Override
    public Fragment getItem(int position) {
        if(!fragmentHashMap.containsKey(position)) {
            fragmentHashMap.put(position, DummyFragment.newInstance(position));
        }

        return fragmentHashMap.get(position);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
