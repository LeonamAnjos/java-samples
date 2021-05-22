package com.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;

class CountTripletsTest {

	@Test
	void countTriplets_whenCase1() {
		List<Long> arr = Arrays.asList(1L, 4L, 16L, 64L);
		long r = 4;
		
		long count = CountTriplets.count(arr, r);
		assertEquals(2, count);
	}
	
	@Test
	void countTriplets_whenCase2() {
		List<Long> arr = Arrays.asList(1L, 2L, 2L, 4L);
		long r = 2;
		
		long count = CountTriplets.count(arr, r);
		assertEquals(2, count);
	}
	
	@Test
	void countTriplets_whenCase3() {
		List<Long> arr = Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L);
		long r = 3;
		
		long count = CountTriplets.count(arr, r);
		assertEquals(6, count);
	}

	
	@Test
	void countTriplets_whenCase4() {
		List<Long> arr = Arrays.asList(1L, 1L, 2L, 2L, 4L, 4L);
		long r = 2;
		
		long count = CountTriplets.count(arr, r);
		assertEquals(8, count);
	}

	@Test
	void countTriplets_whenCase5() {
		List<Long> arr = new ArrayList<>();
		LongStream.range(1, 101).forEach(i -> arr.add(1L));
		long r = 1;
		
		long count = CountTriplets.count(arr, r);
		assertEquals(161700, count);
	}
	
	@Test
	void countTriplets_whenCase6() {
		List<Long> arr = new ArrayList<>();
		LongStream.range(1, 4).forEach(i -> arr.add(1L));
		long r = 1;
		
		long count = CountTriplets.count(arr, r);
		assertEquals(1, count);
	}
	
	@Test
	void countTriplets_whenCase8() {
		List<Long> arr = new ArrayList<>();
		LongStream.range(1, 6).forEach(i -> arr.add(1L));
		long r = 1;
		
		long count = CountTriplets.count(arr, r);
		assertEquals(10, count);
	}
	
	@Test
	void countTriplets_whenCase7() {
		List<Long> arr = new ArrayList<>();
		LongStream.range(1, 5).forEach(i -> arr.add(1L));
		long r = 1;
		
		long count = CountTriplets.count(arr, r);
		assertEquals(4, count);
	}

}