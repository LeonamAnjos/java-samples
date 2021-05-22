package com.samples;

import java.util.List;

public class BubbleSort {

	public static class SwapsResult {
		public int swaps;
		public int firstElement;
		public int lastElement;
	}

	public static SwapsResult getCountOfSwaps(List<Integer> a) {
		SwapsResult result = new SwapsResult();

        int n = a.size();
        int[] b = a.stream().mapToInt(i->i).toArray();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (b[j] > b[j + 1]) {
                    int x = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = x;
                    result.swaps++;
                }
            }
        }

        result.firstElement = b[0];
        result.lastElement = b[b.length - 1];

		return result;
	}

}
