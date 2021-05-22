package com.samples;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class FraudulentActivityNotificatorTest {

	@Test
	void notifications_whenCase1() {
		int d = 3;
		List<Integer> expenditure = asList(10, 20, 30, 40, 50);
		int qnt = FraudulentActivityNotificator.notifications(expenditure, d);
		assertEquals(1, qnt);
	}

	@Test
	void notifications_whenCase2() {
		int d = 5;
		List<Integer> expenditure = asList(2, 3, 4, 2, 3, 6, 8, 4, 5);
		int qnt = FraudulentActivityNotificator.notifications(expenditure, d);
		assertEquals(2, qnt);
	}

}
