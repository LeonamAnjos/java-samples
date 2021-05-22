package com.samples;

import java.util.Collections;
import java.util.List;

public class MarkAndToys {

	public static int maximumToys(List<Integer> prices, int k) {
		Collections.sort(prices);

		int count = 0;
		int sum = 0;
		for(int price : prices) {
			sum += price;
			if (sum <= k) {
				count++;
			} else {
				break;
			}
		}

		return count;
	}

}
