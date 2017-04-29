package com.adventurooapps.crypto.api;

import android.util.Log;

import java.util.List;

import com.adventurooapps.crypto.R;
import com.adventurooapps.crypto.api.interfaces.CoinMarketCapApi;
import com.adventurooapps.crypto.api.interfaces.ResponseHandler;
import com.adventurooapps.crypto.api.models.CryptoCurrency;
import com.adventurooapps.crypto.api.models.GlobalStats;
import com.adventurooapps.crypto.views.BaseApplication;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jcailteux on 4/29/17.
 */

public final class ApiManager {

	private String TAG = "ApiManager";

	private String baseUrl = BaseApplication.getBaseApplication().getString(R.string.api_base_url);
	private Retrofit retrofit;
	private CoinMarketCapApi coinMarketCapApi;

	private ApiManager() {
		retrofit = new Retrofit.Builder()
				.baseUrl(baseUrl)
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		coinMarketCapApi = retrofit.create(CoinMarketCapApi.class);

	}

	private static class SingletonHolder {
		public static ApiManager instance = new ApiManager();
	}

	public static ApiManager getInstance() {
		return SingletonHolder.instance;
	}

	private <T> retrofit2.Callback getCallback(final ResponseHandler<T> handler) {
		Callback<T> callback = new Callback<T>() {
			@Override
			public void onResponse(Call<T> call, Response<T> response) {
				Log.d(TAG, response.toString());
				//200
				if (response.isSuccessful()) {
					handler.onSuccess(response.body());
				} else {
					//400,500
					//TODO more error checking
					handler.onFailure(new Throwable());
				}
			}

			@Override
			public void onFailure(Call<T> call, Throwable throwable) {
				Log.d(TAG, throwable.getLocalizedMessage());
				handler.onFailure(throwable);
			}
		};
		return callback;
	}

	public void getCryptoCurrencies(final ResponseHandler<List<CryptoCurrency>> handler) {
		Call<List<CryptoCurrency>> call = coinMarketCapApi.listCryptoCurrencies();
		call.enqueue(getCallback(handler));
	}

	public void getGlobalStats(final ResponseHandler<GlobalStats> handler) {
		Call<GlobalStats> call = coinMarketCapApi.getGlobalStats();
		call.enqueue(getCallback(handler));
	}


}
