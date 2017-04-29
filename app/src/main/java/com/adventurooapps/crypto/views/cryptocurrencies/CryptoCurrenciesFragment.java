package com.adventurooapps.crypto.views.cryptocurrencies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import com.adventurooapps.crypto.R;
import com.adventurooapps.crypto.api.ApiManager;
import com.adventurooapps.crypto.api.interfaces.ResponseHandler;
import com.adventurooapps.crypto.api.models.CryptoCurrency;
import com.adventurooapps.crypto.views.BaseFragment;

/**
 * Created by jcailteux on 4/29/17.
 */

public class CryptoCurrenciesFragment extends BaseFragment {

	private RecyclerView recyclerView;
	private CryptoCurrenciesRecyclerAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
							 Bundle savedInstanceState) {
		return inflater.inflate(R.layout.f_cryptocurrencies, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		recyclerView = (RecyclerView) view.findViewById(R.id.cryptocurrencies_recyclerview);

		setupRecyclerView();
	}

	private void setupRecyclerView() {
		recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
		adapter = new CryptoCurrenciesRecyclerAdapter();
		recyclerView.setAdapter(adapter);

		reloadData();
	}

	private void reloadData() {
		ApiManager.getInstance().getCryptoCurrencies(new ResponseHandler<List<CryptoCurrency>>() {
			@Override
			public void onSuccess(List<CryptoCurrency> response) {
				adapter.setCryptoCurrencyList(response);
				adapter.notifyDataSetChanged();
			}

			@Override
			public void onFailure(Throwable throwable) {
				//TODO move error text to strings
				Toast.makeText(getContext(), "Failed to get data", Toast.LENGTH_SHORT).show();
			}
		});
	}

}
