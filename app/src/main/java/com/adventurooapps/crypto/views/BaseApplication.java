package com.adventurooapps.crypto.views;

import android.app.Application;

/**
 * Created by jcailteux on 4/29/17.
 */

public class BaseApplication extends Application {

	public static BaseApplication baseApplication;

	public static BaseApplication getBaseApplication() {
		return baseApplication;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		baseApplication = this;
	}


}
