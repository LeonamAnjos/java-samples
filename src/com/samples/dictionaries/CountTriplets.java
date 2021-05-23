package com.samples.dictionaries;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {


	public static long count(List<Long> arr, long r) {
		Map<Long, Long> potential = new HashMap<>();
        Map<Long, Long> counter = new HashMap<>();
        long count = 0;
        for (int i = 0; i < arr.size(); i++) {
            long a = arr.get(i);
            long key = a / r;
            
            if (counter.containsKey(key) && a % r == 0) {
                count += counter.get(key);
            }
            
            if (potential.containsKey(key) && a % r == 0) {
                long c = potential.get(key);
                counter.put(a, counter.getOrDefault(a, 0L) + c);
            }
            
            potential.put(a, potential.getOrDefault(a, 0L) + 1); // Every number can be the start of a triplet.
        }
        return count;
	}

	public static long countBackup(List<Long> arr, long r) {
		int count = 0;
		int size = arr.size();
		for(int i = 0; i < size - 2; i++) {
			long a = arr.get(i);
			for(int y = i + 1; y < size - 1; y++) {
				long a1 = a * r;
				long b = arr.get(y);
				if (b > a1) break;
				if (b < a1) continue;
				for(int z = y + 1; z < size; z++) {
					long a2 = a1 * r;
					long c = arr.get(z);
					if (c > a2) break;
					if (c < a2) continue;
					count++;
				}
			}
		}
		return count;
	}

}
