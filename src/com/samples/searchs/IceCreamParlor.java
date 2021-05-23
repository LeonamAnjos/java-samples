package com.samples.searchs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IceCreamParlor {

	public static int[] whatFlavors(List<Integer> cost, int money) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < cost.size(); i++) {
			if (map.containsKey(money - cost.get(i))) {
				return new int[] { map.get(money - cost.get(i)), i + 1 };
			}
			map.put(cost.get(i), i+1);
		}

		return new int[] { 0, 0 };
	}

}
