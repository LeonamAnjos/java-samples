package com.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AnagramsTest {

	@Test
	void makeAnagram_whenCase1() {
		String a = "cde";
		String b = "dcf";
		int count = Anagrams.makeAnagram(a, b);
		assertEquals(2, count);
	}

	@Test
	void makeAnagram_whenCase2() {
		String a = "cde";
		String b = "abc";
		int count = Anagrams.makeAnagram(a, b);
		assertEquals(4, count);
	}

	@Test
	void makeAnagram_whenCase3() {
		String a = "showman";
		String b = "woman";
		int count = Anagrams.makeAnagram(a, b);
		assertEquals(2, count);
	}

}
