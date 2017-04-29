package com.adventurooapps.crypto.api.interfaces;

/**
 * Created by jcailteux on 4/29/17.
 */

public interface ResponseHandler<T>{
	void onSuccess(T response);
	void onFailure(Throwable throwable);
}
