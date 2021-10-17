package com.connective.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AreaCalculatorApplicationTest {

	@Test
	void test_whenMaxAreaIsInRight() {
		List<Integer> heights = Arrays.asList(1, 8, 6, 2, 5, 4, 8, 3, 7);
		int expected = 49;
		int actual = AreaCalculatorApplication.calculateMaxArea(heights);
		assertEquals(expected, actual);
	}

	@Test
	void test_whenMaxAreaIsInLeft() {
		List<Integer> heights = Arrays.asList(4,3,2,1,4);
		int expected = 16;
		int actual = AreaCalculatorApplication.calculateMaxArea(heights);
		assertEquals(expected, actual);
	}

	@Test
	void test_inputHeights() {
		String inputString = "[1, 8, 6, 2, 5, 4, 8, 3, 7]";
		List<Integer> expected = Arrays.asList(1, 8, 6, 2, 5, 4, 8, 3, 7);
		List<Integer> actual = AreaCalculatorApplication.getInputHeights(inputString);
		assertTrue(expected.equals(actual));
	}

}
