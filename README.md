# Assignment 1 - Unit Test - INFO6255 

## Product of Array Except Self

This Java project implements a solution to the "Product of Array Except Self" problem and includes a comprehensive test suite.

## Problem Description

Given an array `nums` of `n` integers where `n > 1`, return an array `output` such that `output[i]` is equal to the product of all the elements of `nums` except `nums[i]`.

**Example:**
```
Input:  [1,2,3,4]
Output: [24,12,8,6]
```

## Project Structure

```
product-of-array-except-self/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── Solution.java
│   │
│   └── test/
│       └── java/
│           └── SolutionTest.java
│
├── pom.xml
└── README.md
```

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven (for dependency management and running tests)

## Setup

Clone this repository:
```sh
git clone https://github.com/piyushthepandey/INFO6255-Unit-Test.git
cd INFO6255-Unit-Test
```

Ensure you have JDK installed. You can check by running:
```sh
java -version
```

Ensure you have Maven installed. You can check by running:
```sh
mvn -version
```

## Running the Tests

To run the tests, execute the following command in the project root directory:
```sh
mvn test
```
This will compile the code and run all the unit tests.

## Implementation Details

The solution is implemented in the `Solution` class, which contains a single method:
```java
public int[] productExceptSelf(int[] nums)
```
This method takes an integer array as input and returns a new array where each element is the product of all elements in the input array except the one at that index.

The implementation uses two passes through the array to calculate prefix and suffix products, achieving O(n) time complexity without using division.

## Test Cases

The `SolutionTest` class contains a comprehensive set of unit tests covering various scenarios, including:

- Basic input
- Arrays containing zero
- Arrays with negative numbers
- Edge cases (single element, two elements)
- Large arrays
- Performance tests

The tests are structured using the Given-When-Then format for clarity and readability.

