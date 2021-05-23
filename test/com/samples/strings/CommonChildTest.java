package com.samples.strings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CommonChildTest {

	@Test
	void maxLenght_whenCase1() {
		String s1 = "ABCD";
		String s2 = "ABDC";
		int max = CommonChild.maxLength(s1, s2);
		assertEquals(3, max);
	}

	@Test
	void maxLenght_whenCase2() {
		String s1 = "HARRY";
		String s2 = "SALLY";
		int max = CommonChild.maxLength(s1, s2);
		assertEquals(2, max);
	}
	
	@Test
	void maxLenght_whenCase3() {
		String s1 = "AA";
		String s2 = "BB";
		int max = CommonChild.maxLength(s1, s2);
		assertEquals(0, max);
	}
	
	@Test
	void maxLenght_whenCase4() {
		String s1 = "SHINCHAN";
		String s2 = "NOHARAAA";
		int max = CommonChild.maxLength(s1, s2);
		assertEquals(3, max);
	}
	
	@Test
	void maxLenght_whenCase5() {
		String s1 = "ABCDEF";
		String s2 = "FBDAMN";
		int max = CommonChild.maxLength(s1, s2);
		assertEquals(2, max);
	}
	
	@Test
	void maxLenght_whenCase6() {
		String s1 = "ABC";
		String s2 = "AAA";
		int max = CommonChild.maxLength(s1, s2);
		assertEquals(1, max);
	}
}
