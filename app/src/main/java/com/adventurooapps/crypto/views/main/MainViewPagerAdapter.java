package com.adventurooapps.crypto.views.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.adventurooapps.crypto.views.BaseFragment;
import com.adventurooapps.crypto.views.cryptocurrencies.CryptoCurrenciesFragment;
import com.adventurooapps.crypto.views.globalstats.GlobalStatsFragment;

/**
 * Created by jcailteux on 4/29/17.
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    public MainViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        MainTab tab = MainTab.values()[position];

        switch (tab) {
            case CRYPTOCURRENCIES:
                return new CryptoCurrenciesFragment();
            case GLOBALSTATS:
                return new GlobalStatsFragment();
            default:
                return new BaseFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return MainTab.values()[position].name();
    }

    @Override
    public int getCount() {
        return MainTab.values().length;
    }
}
