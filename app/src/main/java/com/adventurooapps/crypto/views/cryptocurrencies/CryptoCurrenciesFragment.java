package com.adventurooapps.crypto.views.cryptocurrencies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import com.adventurooapps.crypto.R;
import com.adventurooapps.crypto.api.ApiManager;
import com.adventurooapps.crypto.api.interfaces.ResponseHandler;
import com.adventurooapps.crypto.api.models.CryptoCurrency;
import com.adventurooapps.crypto.util.MeasurementUtils;
import com.adventurooapps.crypto.views.BaseFragment;

/**
 * Created by jcailteux on 4/29/17.
 */

public class CryptoCurrenciesFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private FrameLayout container;
    private CryptoCurrenciesRecyclerAdapter adapter;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.f_cryptocurrencies, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.cryptocurrencies_recyclerview);
        container = (FrameLayout) view.findViewById(R.id.crypto_container);

        setupProgressBar();
        setupRecyclerView();
    }

    private void setupProgressBar() {
        progressBar = new ProgressBar(getContext());
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(MeasurementUtils.dpToPx(40), MeasurementUtils.dpToPx(40));
        params.gravity = Gravity.CENTER;
        progressBar.setLayoutParams(params);
        container.addView(progressBar);
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
                progressBar.setVisibility(View.GONE);
                adapter.setCryptoCurrencyList(response);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Throwable throwable) {
                progressBar.setVisibility(View.GONE);
                //TODO move error text to strings
                Toast.makeText(getContext(), "Failed to get data", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
