package com.kodilla.testing.shape;

import java.util.*;

class ShapeCollector {
    private ArrayList<Shape> shapes;

    public ShapeCollector() {
        shapes = new ArrayList<>();
    }

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public void removeFigure(Shape shape) {
        shapes.remove(shape);
    }

    public Shape getFigure(int n) {
        if (n >= 0 && n < shapes.size()) {
            return shapes.get(n);
        }
        return null;
    }

    public String showFigures() {
        StringBuilder sb = new StringBuilder();
        for (Shape shape : shapes) {
            sb.append(shape.getShapeName()).append(", ");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2); // Remove the trailing comma and space
        }
        return sb.toString();
    }
}
