package com.adventurooapps.crypto.api.interfaces;

import java.util.List;

import com.adventurooapps.crypto.api.models.CryptoCurrency;
import com.adventurooapps.crypto.api.models.GlobalStats;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by jcailteux on 4/29/17.
 */

public interface CoinMarketCapApi {

	@GET("global")
	Observable<GlobalStats> getGlobalStats();

	@GET("ticker")
	Observable<List<CryptoCurrency>> getCryptoCurrencies();
}
