package com.adventurooapps.crypto.util;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by jcailteux on 4/29/17.
 */

public class MoneyUtils {

	public static String formatUSD(Double d) {
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
		format.setMaximumFractionDigits(2);
		return format.format(d);
	}

	public static String formatUSDMillions(Double d) {
		String suffix = "";
		if (d > 1000000000) {
			d /= 1000000000;
			suffix = "billion";
		} else if (d > 1000000) {
			d /= 1000000;
			suffix = "million";
		} else if (d > 1000) {
			d /= 1000;
			suffix = "thousand";
		}
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
		format.setMaximumFractionDigits(2);
		return format.format(d) + " " + suffix + "/day";
	}
}
