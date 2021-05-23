package com.samples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SherlockAndTheValidStringTest {

	@Test
	void isValid_whenCase1() {
		String s = "abc";
		boolean result = SherlockAndTheValidString.isValid(s);
		assertTrue(result);
	}

	@Test
	void isValid_whenCase2() {
		String s = "abcc";
		boolean result = SherlockAndTheValidString.isValid(s);
		assertTrue(result);
	}
	
	@Test
	void isValid_whenCase3() {
		String s = "abccc";
		boolean result = SherlockAndTheValidString.isValid(s);
		assertFalse(result);
	}
	
	@Test
	void isValid_whenCase4() {
		String s = "aabbcd";
		boolean result = SherlockAndTheValidString.isValid(s);
		assertFalse(result);
	}
	
	@Test
	void isValid_whenCase5() {
		String s = "aabbccddeefghi";
		boolean result = SherlockAndTheValidString.isValid(s);
		assertFalse(result);
	}
	
	@Test
	void isValid_whenCase6() {
		String s = "abcdefghhgfedecba";
		boolean result = SherlockAndTheValidString.isValid(s);
		assertTrue(result);
	}
	
	@Test
	void isValid_whenCase7() {
		String s = "aaacccbbddd";
		boolean result = SherlockAndTheValidString.isValid(s);
		assertFalse(result);
	}
	
	@Test
	void isValid_whenCase8() {
		String s = "abcdeffgg";
		boolean result = SherlockAndTheValidString.isValid(s);
		assertFalse(result);
	}
	
	@Test
	void isValid_whenCase9() {
		String s = "ffagg";
		boolean result = SherlockAndTheValidString.isValid(s);
		assertTrue(result);
	}
	
	@Test
	void isValid_whenCase10() {
		String s = "ffah";
		boolean result = SherlockAndTheValidString.isValid(s);
		assertTrue(result);
	}
	
	@Test
	void isValid_whenCase11() {
		String s = "aaaabb";
		boolean result = SherlockAndTheValidString.isValid(s);
		assertFalse(result);
	}
	
	@Test
	void isValid_whenCase12() {
		String s = "aaaaccccbb";
		boolean result = SherlockAndTheValidString.isValid(s);
		assertFalse(result);
	}
	
	@Test
	void isValid_whenCase13() {
		String s = "abbbbccccdddd";
		boolean result = SherlockAndTheValidString.isValid(s);
		assertTrue(result);
	}
	
	@Test
	void isValid_whenCase14() {
		String s = "abbccc";
		boolean result = SherlockAndTheValidString.isValid(s);
		assertFalse(result);
	}

}
