package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SecondChallengeTest {

    @Test
    public void testProbablyIWillThrowException() {

        //given
        SecondChallenge secondChallenge = new SecondChallenge();

        // when & then
        // x >= 2
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.0, 1.0));

        // x < 1
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.5, 1.0));

        // y == 1.5
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.0, 1.5));

        // x is within range, y is not 1.5
        assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.0, 2.0));
    }
}
