package com.samples.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TestHarness {

	public long timeTasks(int nThreads, Runnable task) throws InterruptedException {
		final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                @Override
				public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException ignored) {
                    }
                }
            };
            t.start();
        }

        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        long elapsedTime = end - start;
		return TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
	}

}
