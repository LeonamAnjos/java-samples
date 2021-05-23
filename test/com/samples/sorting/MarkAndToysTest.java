package com.samples.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MarkAndToysTest {

	@Test
	void maximumToys_whenCase1() {
		int k = 50;
		List<Integer> prices = Arrays.asList(1, 12, 5, 111, 200, 1000, 10);
		int qnt = MarkAndToys.maximumToys(prices, k);
		assertEquals(4, qnt);
	}

}
