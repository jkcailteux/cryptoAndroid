package com.adventurooapps.crypto.views.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.adventurooapps.crypto.views.BaseFragment;
import com.adventurooapps.crypto.views.cryptocurrencies.CryptoCurrenciesFragment;

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
				return new BaseFragment();
			default:
				return new BaseFragment();
		}
	}

	@Override
	public int getCount() {
		return MainTab.values().length;
	}
}
