package com.adventurooapps.crypto.views.cryptocurrencies;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import com.adventurooapps.crypto.api.models.CryptoCurrency;

/**
 * Created by jcailteux on 4/29/17.
 */

public class CryptoCurrenciesRecyclerAdapter extends RecyclerView.Adapter<CryptoCurrencyViewHolder> {

	private final List<CryptoCurrency> cryptoCurrencyList = new ArrayList<>();

	@Override
	public CryptoCurrencyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new CryptoCurrencyViewHolder(CryptoCurrencyView.build(parent.getContext()));
	}

	@Override
	public void onBindViewHolder(CryptoCurrencyViewHolder holder, int position) {
		holder.bindData(cryptoCurrencyList.get(position));
	}

	@Override
	public int getItemCount() {
		return cryptoCurrencyList.size();
	}

	public void setCryptoCurrencyList(List<CryptoCurrency> list) {
		cryptoCurrencyList.clear();
		cryptoCurrencyList.addAll(list);
	}
}
