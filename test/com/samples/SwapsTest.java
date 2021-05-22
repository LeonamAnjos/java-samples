package com.samples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SwapsTest {

	@Test
	void minimumSwaps_whenNoSwapsAreNeeded() {
		int swaps = Swaps.minimumSwaps(new int[] {1, 2, 3, 4, 5});
		assertEquals(0, swaps);
	}
	
	@Test
	void minimumSwaps_whenOneSwapsIsNeeded() {
		int[] arr = new int[] {1, 4, 3, 2, 5};
		int swaps = Swaps.minimumSwaps(arr);
		assertEquals(1, swaps);
	}
}
