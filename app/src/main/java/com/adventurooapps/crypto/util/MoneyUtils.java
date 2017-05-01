package com.adventurooapps.crypto.util;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by jcailteux on 4/29/17.
 */

public class MoneyUtils {

    public static String formatUSD(Double d) {
        int digits = 2;
        if (d < .01) {
            digits = 4;
        } else if (d < .0001) {
            digits = 6;
        } else if (d < .000001) {
            digits = 8;
        }
        return formatUSD(d, digits);
    }

    public static String formatUSD(Double d, int digits) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        format.setMaximumFractionDigits(digits);
        return format.format(d);
    }

    public static String formatUSDScaled(Double d, boolean daily) {
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
        return format.format(d) + " " + suffix + (daily ? "/day" : "");
    }
}
