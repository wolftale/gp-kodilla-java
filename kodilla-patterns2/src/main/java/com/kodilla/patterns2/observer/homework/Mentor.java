package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String name;
    private int updateCount;

    public Mentor(final String name) {
        this.name = name;
    }

    @Override
    public void update(final Homework homework) {
        System.out.println(name + ": New homework from " + homework.getStudentName() + "\n" +
                " (total: " + homework.getHomeworks().size() + " homeworks in queue)");
        updateCount++;
    }

    public String getName() {
        return name;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
