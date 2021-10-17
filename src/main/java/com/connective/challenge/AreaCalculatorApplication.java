package com.connective.challenge;

import java.util.stream.Stream;

public class AreaCalculatorApplication {

	public static void main(String[] args) {
		System.out.println("Input: height = " + args[0]);
		int[] heights = getInputHeights(args[0]);
		System.out.println("Output: " + calculateMaxArea(heights));
	}

	/**
	 * Calculates the maximum area covered by values in an int array
	 * 
	 * @param heights
	 * @return
	 */
	static int calculateMaxArea(int[] heights) {
		int maxArea = 0, index = 0, focuedIndex = 0;

		while (index < heights.length) {
			int currentArea = Math.min(heights[focuedIndex], heights[index]) * (index - focuedIndex);
			if (currentArea > maxArea) {
				maxArea = currentArea;
			}
			// if current height is greater then move focus to current index
			if (heights[focuedIndex] < heights[index]) {
				focuedIndex = index;
			}
			index++;
		}

		return maxArea;
	}

	/**
	 * Returns int array from a string
	 * 
	 * @param inputString
	 * @return
	 */
	static int[] getInputHeights(String inputString) {
		// Remove open/close brackets and split the input string
		String[] splits = inputString.replace("[", "").replace("]", "").split(",");
		int[] heights = Stream.of(splits).map(String::trim).mapToInt(Integer::parseInt).toArray();
		return heights;
	}
}
