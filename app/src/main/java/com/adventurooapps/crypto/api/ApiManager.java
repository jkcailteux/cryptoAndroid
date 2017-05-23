package com.adventurooapps.crypto.api;

import com.adventurooapps.crypto.R;
import com.adventurooapps.crypto.api.interfaces.CoinMarketCapApi;
import com.adventurooapps.crypto.views.BaseApplication;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jcailteux on 4/29/17.
 */

public final class ApiManager {

	private String TAG = "ApiManager";

	private CoinMarketCapApi coinMarketCapApi;

	private ApiManager() {

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(BaseApplication.getBaseApplication().getString(R.string.api_base_url))
				.addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.build();
		coinMarketCapApi = retrofit.create(CoinMarketCapApi.class);

	}

	private static class SingletonHolder {
		public static ApiManager instance = new ApiManager();
	}

	public static ApiManager getInstance() {
		return SingletonHolder.instance;
	}


	public CoinMarketCapApi getCoinMarketCapApi() {
		return coinMarketCapApi;
	}


}
