package com.samples;

import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Bribes {

	public static int minimumBribes(List<Integer> list) {
		int totalBribes = 0;

		NavigableSet<Integer> visited = new TreeSet<Integer>();
		for(int i = 0; i < list.size(); i++) {
			Integer item = list.get(i);
			if (item - (i + 1) > 2) {
				throw new RuntimeException("Too chaotic");				
			}
			
			totalBribes += visited.tailSet(item).size();
			visited.add(item);
		}
		
		return totalBribes;
	}
}
