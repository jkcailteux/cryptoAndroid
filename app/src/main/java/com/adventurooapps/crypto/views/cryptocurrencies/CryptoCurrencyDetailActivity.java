package com.adventurooapps.crypto.views.cryptocurrencies;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.adventurooapps.crypto.api.models.CryptoCurrency;
import com.adventurooapps.crypto.views.BaseActivity;

/**
 * Created by jcailteux on 5/23/17.
 */

public class CryptoCurrencyDetailActivity extends BaseActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}


	public static void startMe(Context context, CryptoCurrency cryptoCurrency) {
		Intent intent = new Intent(context,CryptoCurrencyDetailActivity.class);
		context.startActivity(intent);
	}

}
