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
		int maxArea = 0, leftIndex = 0, index = 1;

		while (index < heights.length) {
			// Calculates the area between left index and index using the min height of
			// index and left index heights
			int currentArea = Math.min(heights[leftIndex], heights[index]) * (index - leftIndex);
			// If the current area is larger then set it as the max area
			if (currentArea > maxArea) {
				maxArea = currentArea;
			}
			// if the index height is greater than the left index height then update the
			// left index
			if (heights[leftIndex] < heights[index]) {
				leftIndex = index;
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
