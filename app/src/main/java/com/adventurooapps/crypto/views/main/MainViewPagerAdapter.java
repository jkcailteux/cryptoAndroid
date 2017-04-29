package com.adventurooapps.crypto.views.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

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
		Fragment fragment;

		switch (tab) {
			case CRYPTOCURRENCIES:
				return null;
			case GLOBALSTATS:
				return null;
			default:
				return null;
		}
	}

	@Override
	public int getCount() {
		return MainTab.values().length;
	}
}
