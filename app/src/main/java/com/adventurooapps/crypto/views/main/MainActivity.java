package com.adventurooapps.crypto.views.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.adventurooapps.crypto.R;
import com.adventurooapps.crypto.views.BaseActivity;

public class MainActivity extends BaseActivity {

	private ViewPager viewPager;
	private TabLayout tabLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		bindViews();
		initViews();
	}

	public void bindViews() {
		viewPager = (ViewPager) findViewById(R.id.main_viewpager);
		tabLayout = (TabLayout) findViewById(R.id.main_tab_layout);
	}

	public void initViews() {
		for (MainTab mainTab : MainTab.values()) {
			tabLayout.addTab(tabLayout.newTab().setText(mainTab.getTabNameId()));
		}

	}
}
