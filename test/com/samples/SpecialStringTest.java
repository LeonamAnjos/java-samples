package com.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SpecialStringTest {

	@Test
	void substrCount_whenCase1() {
		int n = 8;
		String s = "mnonopoo";
		long count = SpecialString.substrCount(n, s);
		assertEquals(12, count);
	}

	@Test
	void substrCount_whenCase2() {
		int n = 5;
		String s = "asasd";
		long count = SpecialString.substrCount(n, s);
		assertEquals(7, count);
	}

	@Test
	void substrCount_whenCase3() {
		int n = 5;
		String s = "aaabb";
		long count = SpecialString.substrCount(n, s);
		assertEquals(9, count);
	}

}
