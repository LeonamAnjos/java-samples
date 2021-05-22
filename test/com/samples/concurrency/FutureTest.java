package com.samples.concurrency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import com.samples.concurrency.Preloader.ProductInfo;

class FutureTest {

	@Test
	void testHarnessTest() throws InterruptedException {
		int nThreads = 10;
		Runnable task = new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		long time = new TestHarness().timeTasks(nThreads, task);
		assertTrue(time > 0);
		assertEquals(1, time);
	}

	@Test
	void preloadTest() throws DataLoadException, InterruptedException {
		Preloader preloader = new Preloader(1);
		preloader.start();

		// comment to break the test
		try {
			 TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long start = System.nanoTime();
		ProductInfo productInfo = preloader.get();
		long end = System.nanoTime();
		long elapsedTime = TimeUnit.SECONDS.convert(end - start, TimeUnit.NANOSECONDS);

		assertTrue(productInfo == null);
		assertEquals(0, elapsedTime);
	}

	@Test
	void boundedHashSetTest() throws InterruptedException {
		BoundedHashSet<String> boundedHashSet = new BoundedHashSet<String>(2);

		assertTrue(boundedHashSet.add("Erster"));
		assertTrue(boundedHashSet.add("Zweiter"));
		assertFalse(boundedHashSet.add("Dritte"));

		assertEquals(2, boundedHashSet.size());

		assertTrue(boundedHashSet.remove("Zweiter"));
		assertFalse(boundedHashSet.remove("Dritte"));

		assertEquals(1, boundedHashSet.size());
	}

	@Test
	void completableFeatureTest() {
		long started = System.currentTimeMillis();

		CompletableFuture<Integer> future = createCompletableFuture(1)
				.thenApply((Integer id) -> id * 100);

//		Delayed Executor:
//		CompletableFuture<Integer> future = new CompletableFuture<>();
//		 future.completeAsync(() -> {
//		       System.out.println("inside future: processing data...");
//		       return 1;
//		 }, CompletableFuture.delayedExecutor(3, TimeUnit.SECONDS))
//		 .thenAccept(result -> System.out.println("accept: " + result));

		// do other work
		System.out.println(String.format("Took %d milliseconds", started - System.currentTimeMillis()));

		// time to get the result
		try {
			int count = future.get();
			System.out.println(String.format("Future took %d milliseconds", started - System.currentTimeMillis()));
			System.out.println(String.format("Result: %d", count));

		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private CompletableFuture<Integer> createCompletableFuture(int id) {
		return CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return id;
		});

	}
}
