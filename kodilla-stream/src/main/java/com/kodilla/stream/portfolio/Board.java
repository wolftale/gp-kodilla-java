package com.kodilla.stream.portfolio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public final class Board {

    private final List<TaskList> taskLists = new ArrayList<>();
    private final String name;

    public Board(final String name) {
        this.name = name;
    }

    public void addTaskList(TaskList taskList) {
        taskLists.add(taskList);
    }

    public boolean removeTaskList(TaskList taskList) {
        return taskLists.remove(taskList);
    }

    public List<TaskList> getTaskLists() {
        return new ArrayList<>(taskLists);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Board{" + "\n" +
                "name='" + name + '\'' + ",\n" +
                "taskLists=" + taskLists + "\n" +
                '}';
    }


    /*
    Zadanie7.6: średnia liczba dni realizacji zadania
     */

    public double calculateAverageDaysInProgress() {
        int sumDays = taskLists.stream()
                .filter(taskList -> taskList.getName().equals("In progress"))
                .flatMap(taskList -> taskList.getTasks().stream())
                .mapToInt(task -> (int) ChronoUnit.DAYS.between(task.getCreated(), LocalDate.now()))
                .sum();

        long count = taskLists.stream()
                .filter(taskList -> taskList.getName().equals("In progress"))
                .flatMap(taskList -> taskList.getTasks().stream())
                .count();

        if (count > 0) {
            return (double) sumDays / count;
        } else {
            return 0.0;
        }
    }
}