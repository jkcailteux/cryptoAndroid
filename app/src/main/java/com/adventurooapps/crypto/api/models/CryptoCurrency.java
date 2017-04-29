package com.adventurooapps.crypto.api.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jcailteux on 4/29/17.
 */

public class CryptoCurrency extends BaseModel {

	private String id;
	private String name;
	private String symbol;
	private int rank;
	@SerializedName("price_usd")
	private double priceUSD;
	@SerializedName("price_btc")
	private double priceBTC;
	@SerializedName("24h_volume_usd")
	private long dailyVolume;
	@SerializedName("market_cap_usd")
	private long marketCap;
	@SerializedName("available_supply")
	private long supply;
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

	public long getDailyVolume() {
		return dailyVolume;
	}

	public long getMarketCap() {
		return marketCap;
	}

	public long getSupply() {
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
