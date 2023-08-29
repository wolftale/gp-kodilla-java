package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String SHOPPINGTASK = "SHOPPINGTASK";
    public static final String PAINTINGTASK = "PAINTINGTASK";
    public static final String DRIVINGTASK = "DRIVINGTASK";

    public final Task makeTask(final String taskClass) {
        return switch (taskClass) {
            case SHOPPINGTASK -> new ShoppingTask("Shopping", "Whisky", 1.0);
            case PAINTINGTASK -> new PaintingTask("Painting", "White", "Wall");
            case DRIVINGTASK -> new DrivingTask("Driving", "Home", "Car");
            default -> null;
        };
    }
}
