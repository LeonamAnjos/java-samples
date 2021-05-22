package com.samples.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

class ExecutorsTest {

	@Test
	void invokeAllTest() throws InterruptedException {
		ExecutorService executor = Executors.newWorkStealingPool();
		List<Callable<String>> callables = Arrays.asList(
				getCallable(3),
				getCallable(1),
				getCallable(2));

		executor.invokeAll(callables)
			.stream()
			.map(future -> {
				try {
					return future.get();
				}
				catch (Exception e) {
					throw new IllegalStateException(e);
				}

			})
			.forEach(System.out::println);
	}

	@Test
	void scheduleTest() throws InterruptedException {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

		Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
		ScheduledFuture<?> future = executor.schedule(task,  3, TimeUnit.SECONDS);

		TimeUnit.MILLISECONDS.sleep(1337);

		long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
		System.out.printf("Remaining Delay: %sms", remainingDelay);
	}

	private Callable<String> getCallable(int timeInSeconds) {
		return () -> {
			TimeUnit.SECONDS.sleep(timeInSeconds);
			return String.format("Finished after %d seconds.", timeInSeconds);
		};
	}

	@Test
	void awaitTermination() throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for(int i = 0; i < 500; i++) {
			final int x = i;
			Runnable worker = new Runnable() {
				@Override
				public void run() {
					try {
						TimeUnit.SECONDS.sleep(3);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(String.format("%d complited!", x));
				}
			};
			executor.execute(worker);
		}

		// block executor to accept new threads and finish all existing threads in the queue
		executor.shutdown();
		executor.awaitTermination(7, TimeUnit.SECONDS);
		System.out.println("Finished!");
	}

}
