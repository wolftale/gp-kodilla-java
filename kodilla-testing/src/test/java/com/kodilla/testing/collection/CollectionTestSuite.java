package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Collection Test Suite")
class CollectionTestSuite {
        private OddNumbersExterminator exterminator;
        private List<Integer> numbers;

        @BeforeEach
        void setUp() {
            exterminator = new OddNumbersExterminator();
            numbers = new ArrayList<>();
            System.out.println("Test Suite begin...");
        }

        @AfterEach
        void tearDown() {
            exterminator = null;
            numbers = null;
            System.out.println("Test Suite end...");
        }

        @DisplayName("Testing exterminate method with an empty list")
        @Test
        void testOddNumbersExterminatorEmptyList() {
            List<Integer> expected = new ArrayList<>();
            List<Integer> result = exterminator.exterminate(numbers);
            assertEquals(expected, result, "The result should be an empty list");
        }

        @DisplayName("Testing exterminate method with a normal list")
        @Test
        void testOddNumbersExterminatorNormalList() {
            numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
            List<Integer> expected = Arrays.asList(2, 4, 6);
            List<Integer> result = exterminator.exterminate(numbers);
            assertEquals(expected, result, "The result should contain only even numbers");
        }
}
