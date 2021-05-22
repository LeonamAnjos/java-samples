package com.samples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyQueries {

	private static final int CHECK = 3;
	private static final int DELETE = 2;
	private static final int INSERT = 1;

	public static List<Integer> run(List<List<Integer>> queries) {
		Map<Integer, Integer> table = new HashMap<>();
		Map<Integer, Integer> qnt = new HashMap<>();

		List<Integer> response = new ArrayList<>();
		for(List<Integer> query : queries) {
			int command = query.get(0);
			int arg = query.get(1);

			switch(command) {
				case INSERT:
					if (!table.containsKey(arg)) {
						table.put(arg, 0);
					}

					int oldValue = table.get(arg);
					int newValue = oldValue + 1;
					table.put(arg, newValue);

					if (!qnt.containsKey(newValue)) {
						qnt.put(newValue, 1);
					} else {
						qnt.put(newValue, qnt.get(newValue) + 1);
					}

					if (oldValue > 0) {
						qnt.put(oldValue, qnt.get(oldValue) - 1);
					}

					break;
				case DELETE:
					if (table.containsKey(arg)) {
						int value = table.get(arg);
						if (value > 0) {
							qnt.put(value, qnt.get(value) - 1);
							value--;
						}
						table.put(arg, value);
						if (value > 0) {
							qnt.put(value, qnt.get(value) + 1);
						}
					}
					break;
				case CHECK:
					if (qnt.containsKey(arg) && qnt.get(arg) > 0) {
						response.add(1);
					} else {
						response.add(0);
					}
//					if (new TreeSet<Integer>(table.values()).contains(arg)) {
//						response.add(1);
//					} else {
//						response.add(0);
//					}
					break;
				default:
			}

		}
		return response;
	}

}
