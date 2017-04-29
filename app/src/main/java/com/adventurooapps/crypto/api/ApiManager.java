package com.adventurooapps.crypto.api;

import com.adventurooapps.crypto.R;
import com.adventurooapps.crypto.views.BaseApplication;

/**
 * Created by jcailteux on 4/29/17.
 */

public class ApiManager {

	private static ApiManager apiManager;

	private static class SingletonHolder {
		public static ApiManager instance = new ApiManager();
	}

	public static ApiManager getInstance() {
		return SingletonHolder.instance;
	}

	public static String getBaseApiUrl(){
		return BaseApplication.getBaseApplication().getString(R.string.api_base_url);
	}




}
