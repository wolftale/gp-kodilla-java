package com.kodilla.stream.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage() {
        // given
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        // when
        double average = ArrayOperations.getAverage(numbers);

        // then
        Assertions.assertEquals(5.0, average);
    }
}
