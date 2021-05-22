package com.samples;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class BribesTest {

	private static final String TOO_CHAOTIC = "Too chaotic";

	@Test
	void minimumBribes_whenNoBribes() {
		int bribes = Bribes.minimumBribes(Stream.of(1, 2, 3, 4, 5, 6).collect(toList()));
		assertEquals(0, bribes);
	}

	@Test
	void minimumBribes_whenThereIsOneBribe() {
		int bribes = Bribes.minimumBribes(Stream.of(1, 2, 3, 5, 4, 6).collect(toList()));
		assertEquals(1, bribes);
	}

	@Test
	void minimumBribes_whenThereAreTwoBribes() {
		int bribes = Bribes.minimumBribes(Stream.of(1, 2, 5, 3, 4, 6).collect(toList()));
		assertEquals(2, bribes);
	}
	
	@Test
	void minimumBribes_whenThereAreManyBribes() {
		int bribes = Bribes.minimumBribes(Stream.of(2, 3, 4, 5, 6, 1).collect(toList()));
		assertEquals(5, bribes);

		bribes = Bribes.minimumBribes(Stream.of(3, 2, 4, 5, 6, 1).collect(toList()));
		assertEquals(6, bribes);

		bribes = Bribes.minimumBribes(Stream.of(3, 4, 2, 6, 5, 1).collect(toList()));
		assertEquals(8, bribes);
	}
		
	@Test
	void minimumBribes_whenTooCahotic() {
		Exception exception = assertThrows(RuntimeException.class, () -> {
			Bribes.minimumBribes(Stream.of(1, 5, 2, 3, 4, 6).collect(toList()));
		});
		
		assertEquals(TOO_CHAOTIC, exception.getMessage());
	}
	
	@Test
	void minimumBribes_whenCase01() {
		int bribes = Bribes.minimumBribes(Stream.of(2, 1, 5, 3, 4).collect(toList()));
		assertEquals(3, bribes);

		Exception exception = assertThrows(RuntimeException.class, () -> {
			Bribes.minimumBribes(Stream.of(2, 5, 1, 3, 4).collect(toList()));
		});

		assertEquals(TOO_CHAOTIC, exception.getMessage());
	}
	
	@Test
	void minimumBribes_whenCase02() {
		int bribes = Bribes.minimumBribes(Stream.of(1, 2, 5, 3, 7, 8, 6, 4).collect(toList()));
		assertEquals(7, bribes);
		
		Exception exception = assertThrows(RuntimeException.class, () -> {
			Bribes.minimumBribes(Stream.of(5, 1, 2, 3, 7, 8, 6, 4).collect(toList()));
		});
		
		assertEquals(TOO_CHAOTIC, exception.getMessage());
	}
	
	@Test
	void minimumBribes_whenCase03() {
		int bribes = Bribes.minimumBribes(Stream.of(1, 2, 5, 3, 4, 7, 8, 6).collect(toList()));
		assertEquals(4, bribes);
	}
	
}
