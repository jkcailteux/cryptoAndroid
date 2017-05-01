package com.adventurooapps.crypto.util;

import android.content.res.Resources;

/**
 * Created by jethr on 4/30/2017.
 */

public class MeasurementUtils {

    public static int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
}
