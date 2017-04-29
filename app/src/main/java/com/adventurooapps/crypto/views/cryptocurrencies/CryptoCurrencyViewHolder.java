package com.adventurooapps.crypto.views.cryptocurrencies;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.adventurooapps.crypto.api.models.CryptoCurrency;

/**
 * Created by jcailteux on 4/29/17.
 */

public class CryptoCurrencyViewHolder extends RecyclerView.ViewHolder {

	private CryptoCurrencyView cryptoCurrencyView;

	public CryptoCurrencyViewHolder(View itemView) {
		super(itemView);
	}

	public CryptoCurrencyViewHolder(CryptoCurrencyView view) {
		super(view);
		this.cryptoCurrencyView = view;
	}

	public void bindData(CryptoCurrency cryptoCurrency) {
		cryptoCurrencyView.setCryptoCurrency(cryptoCurrency);
	}
}
