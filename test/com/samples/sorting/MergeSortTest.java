package com.samples.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MergeSortTest {

	@Test
	void countInterventions_whenCase1() {
		List<Integer> arr = Arrays.asList(2, 4, 1);
		long count = MergeSort.countInterventions(arr);
		assertEquals(2, count);
	}

	@Test
	void countInterventions_whenCase2() {
		List<Integer> arr = Arrays.asList(1, 1, 1, 2, 2);
		long count = MergeSort.countInterventions(arr);
		assertEquals(0, count);
	}

	@Test
	void countInterventions_whenCase3() {
		List<Integer> arr = Arrays.asList(2, 1, 3, 1, 2);
		long count = MergeSort.countInterventions(arr);
		assertEquals(4, count);
	}

	@Test
	void countInterventions_whenCase4() {
		List<Integer> arr = Arrays.asList(9, 8, 7, 6, 4);
		long count = MergeSort.countInterventions(arr);
		assertEquals(10, count);
	}

}
