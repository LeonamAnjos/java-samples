package com.samples;

import java.util.HashMap;
import java.util.Map;

public class Anagrams {

	public static int makeAnagram(String a, String b) {
		int[] letters = new int[26];

		for(int i = 0; i < a.length(); i++) {
			int j = a.charAt(i) - 'a';
			letters[j]++;
		}

		for(int i = 0; i < b.length(); i++) {
			int j = b.charAt(i) - 'a';
			letters[j]--;
		}

		int count = 0;
		for(int i: letters) {
			count += Math.abs(i);
		}

		return count;
	}

	public static int makeAnagram2(String a, String b) {
		Map<Character, Integer> aMap = new HashMap<Character, Integer>();
		Map<Character, Integer> bMap = new HashMap<Character, Integer>();

		for(int i = 0; i < a.length(); i++) {
			if (aMap.containsKey(a.charAt(i))) {
				aMap.replace(a.charAt(i), aMap.get(a.charAt(i)) + 1);
			} else {
				aMap.put(a.charAt(i), 1);
			}

			if (!bMap.containsKey(a.charAt(i))) {
				bMap.put(a.charAt(i), 0);
			}
		}

		for(int i = 0; i < b.length(); i++) {
			if (bMap.containsKey(b.charAt(i))) {
				bMap.replace(b.charAt(i), bMap.get(b.charAt(i)) + 1);
			} else {
				bMap.put(b.charAt(i), 1);
			}

			if (!aMap.containsKey(b.charAt(i))) {
				aMap.put(b.charAt(i), 0);
			}
		}

		int count = 0;
		for(Character c: aMap.keySet()) {
			count += Math.abs(aMap.get(c) - bMap.get(c));
		}

		return count;
	}

}
