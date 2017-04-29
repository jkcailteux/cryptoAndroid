package com.adventurooapps.crypto.api.interfaces;

import java.util.List;

import com.adventurooapps.crypto.api.models.CryptoCurrency;
import com.adventurooapps.crypto.api.models.GlobalStats;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jcailteux on 4/29/17.
 */

public interface CoinMarketCapApi {
	@GET("ticker")
	Call<List<CryptoCurrency>> listCryptoCurrencies();

	@GET("global")
	Call<GlobalStats> getGlobalStats();
}
