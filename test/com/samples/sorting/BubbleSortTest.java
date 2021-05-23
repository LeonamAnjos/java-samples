package com.samples.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.samples.sorting.BubbleSort.SwapsResult;

class BubbleSortTest {

	@Test
	void countSwaps_whenCase1() {
		List<Integer> a = Arrays.asList(6, 4, 1);
		BubbleSort.SwapsResult result = BubbleSort.getCountOfSwaps(a);

		assertEquals(3, result.swaps);
		assertEquals(1, result.firstElement);
		assertEquals(6, result.lastElement);
	}

	@Test
	void countSwaps_whenCase2() {
		List<Integer> a = Arrays.asList(1, 2, 3);
		BubbleSort.SwapsResult result = BubbleSort.getCountOfSwaps(a);

		assertEquals(0, result.swaps);
		assertEquals(1, result.firstElement);
		assertEquals(3, result.lastElement);
	}

	@Test
	void countSwaps_whenCase3() {
		List<Integer> a = Arrays.asList(3, 2, 1);
		BubbleSort.SwapsResult result = BubbleSort.getCountOfSwaps(a);

		assertEquals(3, result.swaps);
		assertEquals(1, result.firstElement);
		assertEquals(3, result.lastElement);
	}

}
