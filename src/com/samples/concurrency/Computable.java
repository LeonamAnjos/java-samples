package com.samples.concurrency;

@FunctionalInterface
public interface Computable<A, V> {
	V compute(A arg) throws InterruptedException;
}
