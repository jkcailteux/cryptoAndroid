package com.adventurooapps.crypto.api.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jcailteux on 4/29/17.
 */

public class CryptoCurrency {

	private String id;
	private String name;
	private String symbol;
	private int rank;
	@SerializedName("price_usd")
	private double priceUSD;
	@SerializedName("price_btc")
	private double priceBTC;
	@SerializedName("24h_volume_usd")
	private double dailyVolume;
	@SerializedName("market_cap_usd")
	private double marketCap;
	@SerializedName("available_supply")
	private double supply;
	@SerializedName("percent_change_1h")
	private double hourChange;
	@SerializedName("percent_change_24h")
	private double dailyChange;
	@SerializedName("percent_change_7d")
	private double weeklyChange;
	@SerializedName("last_updated")
	private long lastUpdated;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSymbol() {
		return symbol;
	}

	public int getRank() {
		return rank;
	}

	public double getPriceUSD() {
		return priceUSD;
	}

	public double getPriceBTC() {
		return priceBTC;
	}

	public double getDailyVolume() {
		return dailyVolume;
	}

	public double getMarketCap() {
		return marketCap;
	}

	public double getSupply() {
		return supply;
	}

	public double getHourChange() {
		return hourChange;
	}

	public double getDailyChange() {
		return dailyChange;
	}

	public double getWeeklyChange() {
		return weeklyChange;
	}

	public long getLastUpdated() {
		return lastUpdated;
	}

}
