package com.adventurooapps.crypto.views.globalstats;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.adventurooapps.crypto.R;
import com.adventurooapps.crypto.api.ApiManager;
import com.adventurooapps.crypto.api.models.GlobalStats;
import com.adventurooapps.crypto.util.MeasurementUtils;
import com.adventurooapps.crypto.util.MoneyUtils;
import com.adventurooapps.crypto.views.BaseFragment;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jcailteux on 4/29/17.
 */

public class GlobalStatsFragment extends BaseFragment {

	private TextView statsTV;
	private ProgressBar progressBar;
	private FrameLayout container;

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
							 Bundle savedInstanceState) {
		return inflater.inflate(R.layout.f_globalstats, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		statsTV = (TextView) view.findViewById(R.id.globalstats_tv);
		container = (FrameLayout) view.findViewById(R.id.container);

		setupProgressBar();
		reloadData();
	}

	private void setupProgressBar() {
		progressBar = new ProgressBar(getContext());
		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(MeasurementUtils.dpToPx(40), MeasurementUtils.dpToPx(40));
		params.gravity = Gravity.CENTER;
		progressBar.setLayoutParams(params);
		container.addView(progressBar);
	}

	private void reloadData() {
		ApiManager.getInstance().getCoinMarketCapApi().getGlobalStats()
				.subscribeOn(Schedulers.newThread())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<GlobalStats>() {
					@Override
					public void onCompleted() {

					}

					@Override
					public void onError(Throwable throwable) {
						progressBar.setVisibility(View.GONE);
						Toast.makeText(getContext(), "Failed to get data", Toast.LENGTH_SHORT).show();
					}

					@Override
					public void onNext(GlobalStats globalStats) {
						progressBar.setVisibility(View.GONE);
						statsTV.setText(buildStatsString(globalStats));
					}
				});
	}

	private String buildStatsString(GlobalStats globalStats) {
		String stats = "";
		stats += "Total Cryptocurrency Market: " + MoneyUtils.formatUSDScaled(globalStats.getTotalMarketCap(), false) + "\n";
		stats += "Total Cryptocurrency Volume: " + MoneyUtils.formatUSDScaled(globalStats.getTotalDailyVolume(), true) + "\n";
		stats += "Bitcoin Dominance: " + globalStats.getBitcoinPercentage() + "%" + "\n";
		stats += "Active Markets: " + globalStats.getActiveMarkets() + "\n";
		stats += "Active Currencies: " + globalStats.getActiveCurrencies() + "\n";
		stats += "Active Assets: " + globalStats.getActiveAssets() + "\n";

		return stats;
	}
}
