package com.kodilla.testing.shape;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ShapeCollectorTestSuite")
class ShapeCollectorTestSuite {

    @Nested
    @DisplayName("when adding figures")
    class AddFigureTests {
        @Test
        @DisplayName("should add a figure to the collection")
        void shouldAddFigureToCollection() {
            // given
            ShapeCollector collector = new ShapeCollector();
            Shape shape = new Square(5.0);

            // when
            collector.addFigure(shape);

            // then
            assertEquals(1, collector.showFigures().split(", ").length);
            assertEquals("Square", collector.showFigures());
        }
    }

    @Nested
    @DisplayName("when removing figures")
    class RemoveFigureTests {
        @Test
        @DisplayName("should remove a figure from the collection")
        void shouldRemoveFigureFromCollection() {
            // given
            ShapeCollector collector = new ShapeCollector();
            Shape shape = new Square(5.0);
            collector.addFigure(shape);

            // when
            collector.removeFigure(shape);

            // then
            assertEquals(0, collector.showFigures().split(", ").length);
            assertEquals("", collector.showFigures());
        }
    }

    @Nested
    @DisplayName("when getting a figure by index")
    class GetFigureTests {
        @Test
        @DisplayName("should return the figure at the specified index")
        void shouldReturnFigureAtIndex() {
            // given
            ShapeCollector collector = new ShapeCollector();
            Shape shape1 = new Square(5.0);
            Shape shape2 = new Circle(3.0);
            collector.addFigure(shape1);
            collector.addFigure(shape2);

            // when
            Shape retrievedShape = collector.getFigure(1);

            // then
            assertEquals(shape2, retrievedShape);
        }

        @Test
        @DisplayName("should return null when the index is out of bounds")
        void shouldReturnNullForOutOfBoundsIndex() {
            // given
            ShapeCollector collector = new ShapeCollector();
            Shape shape = new Square(5.0);
            collector.addFigure(shape);

            // when
            Shape retrievedShape = collector.getFigure(1);

            // then
            assertNull(retrievedShape);
        }
    }

    @Nested
    @DisplayName("when showing all figures")
    class ShowFiguresTests {
        @Test
        @DisplayName("should return names of all figures in a string")
        void shouldReturnNamesOfAllFiguresInString() {
            // given
            ShapeCollector collector = new ShapeCollector();
            Shape shape1 = new Square(5.0);
            Shape shape2 = new Circle(3.0);
            collector.addFigure(shape1);
            collector.addFigure(shape2);

            // when
            String figuresString = collector.showFigures();

            // then
            assertEquals("Square, Circle", figuresString);
        }

        @Test
        @DisplayName("should return an empty string when there are no figures")
        void shouldReturnEmptyStringWhenNoFigures() {
            // given
            ShapeCollector collector = new ShapeCollector();

            // when
            String figuresString = collector.showFigures();

            // then
            assertEquals("", figuresString);
        }
    }
}




