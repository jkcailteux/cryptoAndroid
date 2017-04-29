package com.adventurooapps.crypto.views.main;

import android.support.annotation.StringRes;

import com.adventurooapps.crypto.R;

/**
 * Created by jcailteux on 4/29/17.
 */

public enum MainTab {

	CRYPTOCURRENCIES(R.string.crypto_tab_name), GLOBALSTATS(R.string.global_tab_name);

	@StringRes
	private int tabNameId;

	MainTab(int tabNameId) {
		this.tabNameId = tabNameId;
	}

	public int getTabNameId(){
		return tabNameId;
	}

}
