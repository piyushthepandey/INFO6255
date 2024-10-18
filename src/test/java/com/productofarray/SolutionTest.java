package com.productofarray;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    @DisplayName("Test with basic input")
    void testBasicInput() {
        // Given
        int[] input = {1, 2, 3, 4};
        int[] expected = {24, 12, 8, 6};
        System.out.println("Given input array: " + Arrays.toString(input));
        // When
        System.out.println("When productExceptSelf is called");
        int[] result = solution.productExceptSelf(input);
        // Then
        System.out.println("Then the result should be: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test with array containing zero")
    void testWithZero() {
        // Given
        int[] input = {1, 0, 3, 4};
        int[] expected = {0, 12, 0, 0};
        System.out.println("Given input array with zero: " + Arrays.toString(input));
        // When
        System.out.println("When productExceptSelf is called");
        int[] result = solution.productExceptSelf(input);
        // Then
        System.out.println("Then the result should be: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test with array containing multiple zeros")
    void testWithMultipleZeros() {
        // Given
        int[] input = {0, 0, 3, 4};
        int[] expected = {0, 0, 0, 0};
        System.out.println("Given input array with multiple zeros: " + Arrays.toString(input));
        // When
        System.out.println("When productExceptSelf is called");
        int[] result = solution.productExceptSelf(input);
        // Then
        System.out.println("Then the result should be: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test with array of length 1")
    void testSingleElementArray() {
        // Given
        int[] input = {5};
        int[] expected = {1};
        System.out.println("Given single element array: " + Arrays.toString(input));
        // When
        System.out.println("When productExceptSelf is called");
        int[] result = solution.productExceptSelf(input);
        // Then
        System.out.println("Then the result should be: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(result));
        assertArrayEquals(expected, result);
        assertEquals(1, result[0]); // Explicitly check the value
    }

    @Test
    @DisplayName("Test with null input")
    void testNullInput() {
        // Given
        System.out.println("Given null input");
        // When
        System.out.println("When productExceptSelf is called");
        // Then
        System.out.println("Then IllegalArgumentException should be thrown");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> solution.productExceptSelf(null));
        System.out.println("Exception message: " + exception.getMessage());
    }

    @Test
    @DisplayName("Test with empty array")
    void testEmptyArray() {
        // Given
        System.out.println("Given empty array");
        // When
        System.out.println("When productExceptSelf is called");
        // Then
        System.out.println("Then IllegalArgumentException should be thrown");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> solution.productExceptSelf(new int[]{}));
        System.out.println("Exception message: " + exception.getMessage());
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Parameterized test for various inputs")
    void parameterizedTest(int[] input, int[] expected) {
        // Given
        System.out.println("Given input array: " + Arrays.toString(input));
        // When
        System.out.println("When productExceptSelf is called");
        int[] result = solution.productExceptSelf(input);
        // Then
        System.out.println("Then the result should be: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 4}, new int[]{24, 12, 8, 6}),
            Arguments.of(new int[]{-1, 1, 0, -3, 3}, new int[]{0, 0, 9, 0, 0}),
            Arguments.of(new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 1})
        );
    }

    @Test
    @DisplayName("Test with all negative numbers")
    void testAllNegativeNumbers() {
        // Given
        int[] input = {-1, -2, -3, -4};
        int[] expected = {-24, -12, -8, -6};
        System.out.println("Given array with all negative numbers: " + Arrays.toString(input));
        // When
        System.out.println("When productExceptSelf is called");
        int[] result = solution.productExceptSelf(input);
        // Then
        System.out.println("Then the result should be: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test performance with large array")
    void testPerformanceWithLargeArray() {
        // Given
        int[] input = new int[1000000];
        Arrays.fill(input, 2);
        System.out.println("Given large array of size: " + input.length);
        // When
        System.out.println("When productExceptSelf is called");
        long startTime = System.nanoTime();
        solution.productExceptSelf(input);
        long endTime = System.nanoTime();
        // Then
        long duration = (endTime - startTime) / 1000000;  // Convert to milliseconds
        System.out.println("Then execution time should be less than 1000 ms");
        System.out.println("Actual execution time: " + duration + " ms");
        assertTrue(duration < 1000, "Execution took too long: " + duration + " ms");
    }

    @Test
    @DisplayName("Test with Integer.MAX_VALUE")
    void testWithIntegerMaxValue() {
        // Given
        int[] input = {Integer.MAX_VALUE, 2};
        int[] expected = {2, Integer.MAX_VALUE};
        System.out.println("Given array with Integer.MAX_VALUE: " + Arrays.toString(input));
        // When
        System.out.println("When productExceptSelf is called");
        int[] result = solution.productExceptSelf(input);
        // Then
        System.out.println("Then the result should be: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }
}