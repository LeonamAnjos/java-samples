package com.samples.strings;

import java.util.ArrayList;
import java.util.Collections;

public class SherlockAndTheValidString {

	public static boolean isValid(String s) {
		int[] counter = new int[26];
		for(char c : s.toCharArray()) {
			counter[c - 'a']++;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i : counter) {
			if (i == 0) continue;
			list.add(i);
		}
		
		Collections.sort(list);
		int toRemove = 1;
		int position = 0;
		
		int distinct = 0;
		int prev = 0;
		
		boolean confirmed = false;
		
		for(int i : list) {
			if (prev != i) {
				prev = i;
				distinct++;
			}
			
			if (position == 0) {
				position = i;
				continue;
			}
			
			confirmed = confirmed || (position == i);
			
			if (i > position) {
				toRemove -= (i - position);
			}
			
			if (toRemove < 0) {
				if (!confirmed && position == 1 && distinct < 3) {
					position = i;
					toRemove = 0;
				} else {
					return false;					
				}
			}
		}
		
		return true;
	}
}
