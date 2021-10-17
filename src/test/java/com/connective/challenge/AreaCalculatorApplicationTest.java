package com.connective.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class AreaCalculatorApplicationTest {

	@Test
	void test_whenMaxAreaIsInRight() {
		int[] heights = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int expected = 49;
		int actual = AreaCalculatorApplication.calculateMaxArea(heights);
		assertEquals(expected, actual);
	}

	@Test
	void test_whenMaxAreaIsInLeft() {
		int[] heights = new int[] { 4, 2, 3, 2, 6, 4, 6 };
		int expected = 16;
		int actual = AreaCalculatorApplication.calculateMaxArea(heights);
		assertEquals(expected, actual);
	}

	@Test
	void test_inputHeights() {
		String inputString = "[1, 8, 6, 2, 5, 4, 8, 3, 7]";
		int[] expected = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int[] actual = AreaCalculatorApplication.getInputHeights(inputString);
		assertTrue(Arrays.equals(expected, actual));
	}

}
