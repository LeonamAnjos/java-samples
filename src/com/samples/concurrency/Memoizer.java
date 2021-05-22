package com.samples.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Memoizer<A, V> implements Computable<A, V> {
	private final ConcurrentMap<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
	private final Computable<A, V> computable;

	public Memoizer(Computable<A, V> computable) {
		this.computable = computable;
	}

	@Override
	public V compute(final A arg) throws InterruptedException {
		while (true) {
			Future<V> future = cache.get(arg);
			if (future == null) {
				Callable<V> eval = new Callable<V>() {
					@Override
					public V call() throws InterruptedException {
						return computable.compute(arg);
					}
				};
				FutureTask<V> futureTask = new FutureTask<V>(eval);
				future = cache.putIfAbsent(arg, futureTask);
				if (future == null) {
					future = futureTask;
					futureTask.run();
				}
			}

			try {
				return future.get();
			} catch (CancellationException e) {
				cache.remove(arg, future);
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

}
