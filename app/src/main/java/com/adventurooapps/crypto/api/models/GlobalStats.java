package com.adventurooapps.crypto.api.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jcailteux on 4/29/17.
 */

public class GlobalStats {
	@SerializedName("total_market_cap_usd")
	private double totalMarketCap;
	@SerializedName("total_24h_volume_usd")
	private double totalDailyVolume;
	@SerializedName("bitcoin_percentage_of_market_cap")
	private double bitcoinPercentage;
	@SerializedName("active_currencies")
	private int activeCurrencies;
	@SerializedName("active_assets")
	private int activeAssets;
	@SerializedName("activeMarkets")
	private int activeMarkets;


	public double getTotalMarketCap() {
		return totalMarketCap;
	}

	public double getTotalDailyVolume() {
		return totalDailyVolume;
	}

	public double getBitcoinPercentage() {
		return bitcoinPercentage;
	}

	public int getActiveCurrencies() {
		return activeCurrencies;
	}

	public int getActiveAssets() {
		return activeAssets;
	}

	public int getActiveMarkets() {
		return activeMarkets;
	}

}
