package com.adventurooapps.crypto.views.cryptocurrencies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.adventurooapps.crypto.R;
import com.adventurooapps.crypto.api.models.CryptoCurrency;
import com.adventurooapps.crypto.util.MoneyUtils;

/**
 * Created by jcailteux on 4/29/17.
 */

public class CryptoCurrencyView extends FrameLayout {

	private CryptoCurrency cryptoCurrency;

	private TextView nameTV, priceTV, volumeTV;

	public CryptoCurrencyView(@NonNull Context context) {
		super(context);
		init();
	}

	public CryptoCurrencyView(@NonNull Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public CryptoCurrencyView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	public CryptoCurrencyView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		init();
	}

	private void init() {
		inflate(getContext(), R.layout.v_cryptocurrency, this);
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		nameTV = (TextView) findViewById(R.id.name_tv);
		priceTV = (TextView) findViewById(R.id.price_tv);
		volumeTV = (TextView) findViewById(R.id.volume_tv);
	}

	public static CryptoCurrencyView build(Context context) {
		CryptoCurrencyView view = new CryptoCurrencyView(context);
		view.onFinishInflate();
		return view;
	}

	public void setCryptoCurrency(CryptoCurrency cryptoCurrency) {
		this.cryptoCurrency = cryptoCurrency;
		nameTV.setText(cryptoCurrency.getName());
		priceTV.setText(MoneyUtils.formatUSD(cryptoCurrency.getPriceUSD()));
		volumeTV.setText(MoneyUtils.formatUSDScaled(cryptoCurrency.getDailyVolume(), true));
	}
}
