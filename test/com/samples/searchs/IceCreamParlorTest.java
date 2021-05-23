package com.samples.searchs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.samples.searchs.IceCreamParlor;

class IceCreamParlorTest {

	@Test
	void whatFlavors_whenCase1() {
		List<Integer> cost = Arrays.asList(1, 4, 5, 3, 2);
		int money = 4;
		int[] flavors = IceCreamParlor.whatFlavors(cost, money);
		assertArrayEquals(new int[] {1, 4}, flavors);
	}
	
	@Test
	void whatFlavors_whenCase2() {
		List<Integer> cost = Arrays.asList(2, 2, 4, 3);
		int money = 4;
		int[] flavors = IceCreamParlor.whatFlavors(cost, money);
		assertArrayEquals(new int[] {1, 2}, flavors);
	}
	
	@Test
	void whatFlavors_whenCase3() {
		List<Integer> cost = Arrays.asList(1, 2, 3, 5, 6);
		int money = 5;
		int[] flavors = IceCreamParlor.whatFlavors(cost, money);
		assertArrayEquals(new int[] {2, 3}, flavors);
	}
	
	@Test
	void whatFlavors_whenCase4() {
		List<Integer> cost = Arrays.asList(4, 3, 2, 5, 7);
		int money = 8;
		int[] flavors = IceCreamParlor.whatFlavors(cost, money);
		assertArrayEquals(new int[] {2, 4}, flavors);
	}
	
	@Test
	void whatFlavors_whenCase5() {
		List<Integer> cost = Arrays.asList(7, 2, 5, 4, 11);
		int money = 12;
		int[] flavors = IceCreamParlor.whatFlavors(cost, money);
		assertArrayEquals(new int[] {1, 3}, flavors);
	}

}
