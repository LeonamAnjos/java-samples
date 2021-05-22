package com.samples;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class FrequencyQueriesTest {

	@Test
	void frequencyQuery_whenCase1() {
		List<List<Integer>> queries = asList(
				asList(1, 1),
				asList(2, 2),
				asList(3, 2),
				asList(1, 1),
				asList(1, 1),
				asList(2, 1),
				asList(3, 2));

		List<Integer> result = FrequencyQueries.run(queries);
		assertIterableEquals(asList(0, 1), result);
	}

	@Test
	void frequencyQuery_whenCase2() {
		List<List<Integer>> queries = asList(
				asList(1, 5),
				asList(1, 6),
				asList(3, 2),
				asList(1, 10),
				asList(1, 10),
				asList(1, 6),
				asList(2, 5),
				asList(3, 2));

		List<Integer> result = FrequencyQueries.run(queries);
		assertIterableEquals(asList(0, 1), result);
	}
}
