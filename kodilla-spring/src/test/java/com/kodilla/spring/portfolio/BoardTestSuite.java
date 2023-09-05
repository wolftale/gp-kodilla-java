package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testTaskAdd() {

        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Board board = context.getBean(Board.class);

        TaskList toDoList = board.getToDoList();
        TaskList inProgressList = board.getInProgressList();
        TaskList doneList = board.getDoneList();

        toDoList.addTask("Task 1");
        inProgressList.addTask("Task 2");
        doneList.addTask("Task 3");

        //When
        String toDoTask = toDoList.getTask(0);
        String inProgressTask = inProgressList.getTask(0);
        String doneTask = doneList.getTask(0);

        //Then
        assertEquals("Task 1", toDoTask);
        assertEquals("Task 2", inProgressTask);
        assertEquals("Task 3", doneTask);
    }
}
    // Alternatywnie można zrobić bez "String" tak:
    // .....
    // //Then
    // assertEquals("Task 1", board.getToDoList().getTask(0));
    // assertEquals("Task 2", board.getInProgressList().getTask(0));
    // assertEquals("Task 3", board.getDoneList().getTask(0));
