package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeworkTestSuite {

    @Test
    void testUpdate() {
        // Given
        Homework homework1 = new Homework("John Smith");
        Homework homework2 = new Homework("Alice Brown");
        Homework homework3 = new Homework("Tom White");

        Mentor mentor1 = new Mentor("Mentor 1");
        Mentor mentor2 = new Mentor("Mentor 2");
        Mentor mentor3 = new Mentor("Mentor 3");

        homework1.registerObserver(mentor1);
        homework2.registerObserver(mentor2);
        homework3.registerObserver(mentor3);
        homework1.registerObserver(mentor3);
        homework2.registerObserver(mentor1);


        // When
        homework1.addHomework("Task 1");
        homework1.addHomework("Task 2");
        homework2.addHomework("Task 3");
        homework3.addHomework("Task 4");

        // Then
        assertEquals(3, mentor1.getUpdateCount());
        assertEquals(1, mentor2.getUpdateCount());
        assertEquals(3, mentor3.getUpdateCount());
    }
}
