package com.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ArrayManipulationTest {

	@Test
	void arrayManipulation_whenCase1() {
		int n = 10;
		List<List<Integer>> queries = new ArrayList<>();
		queries.add(Arrays.asList(1, 5, 3));
		queries.add(Arrays.asList(4, 8, 7));
		queries.add(Arrays.asList(6, 9, 1));
		
		long actual = ArrayManipulation.arrayManipulation(n, queries);
		assertEquals(10, actual);
	}

	@Test
	void arrayManipulation_whenCase2() {
		int n = 5;
		List<List<Integer>> queries = new ArrayList<>();
		queries.add(Arrays.asList(1, 2, 100));
		queries.add(Arrays.asList(2, 5, 100));
		queries.add(Arrays.asList(3, 4, 100));
		
		long actual = ArrayManipulation.arrayManipulation(n, queries);
		assertEquals(200, actual);
	}
	
	@Test
	void arrayManipulation_whenCase3() {
		int n = 10;
		List<List<Integer>> queries = new ArrayList<>();
		queries.add(Arrays.asList(1, 5,  3));
		queries.add(Arrays.asList(4, 8,  7));
		queries.add(Arrays.asList(6, 9,  1));
		queries.add(Arrays.asList(5, 9,  1));
		queries.add(Arrays.asList(1, 10, 2));
		
		long actual = ArrayManipulation.arrayManipulation(n, queries);
		assertEquals(13, actual);
	}
}
