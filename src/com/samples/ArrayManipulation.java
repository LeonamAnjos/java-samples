package com.samples;

import java.util.List;

public class ArrayManipulation {

	public static long arrayManipulation(int n, List<List<Integer>> queries) {
		long result = 0;
		long[] arr = new long[n];
		
		for(List<Integer> query : queries) {
			int a = query.get(0);
			int b = query.get(1);
			int z = query.get(2);
			
			if (z == 0) continue;
			
			arr[a-1] += z;
			if (b < n) {
				arr[b] -= z;
			}
		}
		
		long sum = 0;
		for(long v : arr) {
			sum += v;
			if (result < sum) {
				result = sum;
			}
		}
		
		return result;
	}
}
