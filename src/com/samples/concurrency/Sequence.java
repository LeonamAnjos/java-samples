package com.samples.concurrency;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Sequence {

	// avoid getting value from CPU cache
	private volatile int nextValue;

	public int getNextValue() {
		return nextValue;
	}

	public synchronized void increment() {
		this.nextValue++;
	}

	public void increment2() {
		synchronized(this) {
			this.nextValue++;
		}
	}

	// prioritize longer waiting threads
	private final ReentrantLock reLock = new ReentrantLock(true);
	public void increment3() {
		reLock.lock();
		try {
			this.nextValue++;
		} finally {
			reLock.unlock();
		}
	}

	// lock the read and write blocks when there is a thread writing.
	private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
	private final Lock readLock = rwLock.readLock();
	private final Lock writeLock = rwLock.writeLock();
	public void increment4() {
		writeLock.lock();
		try {
			this.nextValue++;
		} finally {
			writeLock.unlock();
		}
	}

	public int getNextValueWithLock() {
		readLock.lock();
		try {
			return this.nextValue;
		} finally {
			readLock.unlock();
		}
	}


	// Thread safe methods
//	private AtomicBoolean boolValue = new AtomicBoolean();
	private AtomicLong longValue = new AtomicLong();
	public long incrementLong() {
//		longValue.compareAndSet(1, 2);
		return longValue.incrementAndGet();
	}

}
