package com.connective.challenge;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AreaCalculatorApplication {

	public static void main(String[] args) {
		System.out.println("Input: height = " + args[0]);
		List<Integer> heights = getInputHeights(args[0]);
		System.out.println("Output: " + calculateMaxArea(heights));
	}

	/**
	 * Calculates the maximum area covered by values in an int array
	 * 
	 * @param heights
	 * @return
	 */
	static int calculateMaxArea(List<Integer> heights) {
		int maxArea = 0, index = 0;

		while (index < heights.size()) {
			int currentIndex = index;
			int currentValue = heights.get(currentIndex);			
			// find all values equal or larger than the current value and get the farthest index
			OptionalInt indices = IntStream.range(0, heights.size())
					.filter(i -> ((i != currentIndex) && (heights.get(i) >= currentValue)))
					.map(i -> Math.abs(i - currentIndex)).max();
			if (indices.isPresent()) {
				int bestIndex = indices.getAsInt();
				int currentArea = currentValue * bestIndex;
				// If the current area is larger the max area then set it as the max area
				if (currentArea > maxArea) {
					maxArea = currentArea;
				}
			}
			index++;
		}

		return maxArea;
	}

	/**
	 * Converts input string to Integer List
	 * 
	 * @param inputString
	 * @return
	 */
	static List<Integer> getInputHeights(String inputString) {
		// Remove open/close brackets and split the input string
		String[] splits = inputString.replace("[", "").replace("]", "").split(",");
		List<Integer> inputNumbers = Stream.of(splits).map(String::trim).mapToInt(Integer::parseInt).boxed()
				.collect(Collectors.toList());
		return inputNumbers;
	}
}
