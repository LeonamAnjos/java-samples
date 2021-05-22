package com.samples;

public class Swaps {

	public static int minimumSwaps(int[] arr) {
		int swaps = 0;
		for(int i = 0; i < arr.length; i++) {
			int value = arr[i];
			while (value != i + 1) {
				arr[i] = arr[value - 1];
				arr[value - 1] = value;
				swaps++;
				value = arr[i];
			}
		}
		return swaps;
	}

}
