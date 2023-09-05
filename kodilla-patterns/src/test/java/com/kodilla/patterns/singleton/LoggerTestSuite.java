package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    @Test
    void testGetLastLog() {
        //Given
        Logger.getInstance().log("Test log");
        //When
        String result = Logger.getInstance().getLastLog();
        System.out.println("Last log: " + result);
        //Then
        assertEquals("Test log", result);
    }
}
