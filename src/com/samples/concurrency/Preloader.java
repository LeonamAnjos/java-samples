package com.samples.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class Preloader {

	private int timeInSecondsToSleep;

	public Preloader(int timeInSecondsToSleep) {
		this.timeInSecondsToSleep = timeInSecondsToSleep;
	}

	private ProductInfo loadProductInfo() throws DataLoadException {
		try {
			 TimeUnit.SECONDS.sleep(timeInSecondsToSleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return null;
	}

	private final FutureTask<ProductInfo> future =
	    new FutureTask<ProductInfo>(
	    		new Callable<ProductInfo>() {
	    			@Override
					public ProductInfo call() throws DataLoadException {
	    				return loadProductInfo();
	    			}
	    		});

	private final Thread thread = new Thread(future);

	public void start() { thread.start(); }

	public ProductInfo get() throws DataLoadException, InterruptedException {
		try {
			return future.get();
	    } catch (ExecutionException e) {
	    	Throwable cause = e.getCause();
	    	if (cause instanceof DataLoadException)
	            throw (DataLoadException) cause;
	        else
	            throw new RuntimeException(cause);
	    }
	}

	interface ProductInfo {
	}
}

class DataLoadException extends Exception { }
