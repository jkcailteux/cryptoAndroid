package com.adventurooapps.crypto.views.globalstats;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adventurooapps.crypto.R;
import com.adventurooapps.crypto.api.ApiManager;
import com.adventurooapps.crypto.api.interfaces.ResponseHandler;
import com.adventurooapps.crypto.api.models.GlobalStats;
import com.adventurooapps.crypto.views.BaseFragment;

/**
 * Created by jcailteux on 4/29/17.
 */

public class GlobalStatsFragment extends BaseFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
							 Bundle savedInstanceState) {
		return inflater.inflate(R.layout.f_cryptocurrencies, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		reloadData();
	}

	private void reloadData(){
		ApiManager.getInstance().getGlobalStats(new ResponseHandler<GlobalStats>() {
			@Override
			public void onSuccess(GlobalStats response) {
				response.getActiveAssets();
				//TODO bind data on UI
			}

			@Override
			public void onFailure(Throwable throwable) {

			}
		});
	}
}
