package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    void testBasicPizzaOrderGetCost() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        // When
        BigDecimal cost = pizzaOrder.getCost();

        // Then
        assertEquals(new BigDecimal(12), cost);
    }

    @Test
    void testBasicPizzaOrderGetDescription() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        // When
        String description = pizzaOrder.getDescription();

        // Then
        assertEquals("Pizza with cheese and tomato sauce", description);
    }

    @Test
    void testLargePizzaOrderGetCost() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new LargePizzaDecorator(pizzaOrder);
        // When
        BigDecimal cost = pizzaOrder.getCost();

        // Then
        assertEquals(new BigDecimal(24), cost);
    }

    @Test
    void testLargePizzaOrderGetDescription() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new LargePizzaDecorator(pizzaOrder);
        // When
        String description = pizzaOrder.getDescription();

        // Then
        assertEquals("Pizza with cheese and tomato sauce + large size", description);
    }


    @Test
    void testPizzaOrderWithExtraCheeseGetCost() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        // When
        BigDecimal cost = pizzaOrder.getCost();

        // Then
        assertEquals(new BigDecimal(17), cost);
    }

    @Test
    void testPizzaOrderWithExtraCheeseGetDescription() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        // When
        String description = pizzaOrder.getDescription();

        // Then
        assertEquals("Pizza with cheese and tomato sauce + extra cheese", description);
    }

    @Test
    void testPizzaOrderWithExtraCheeseAndHamGetCost() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        pizzaOrder = new HamPizzaDecorator(pizzaOrder);
        // When
        BigDecimal cost = pizzaOrder.getCost();

        // Then
        assertEquals(new BigDecimal(27), cost);
    }

    @Test
    void testPizzaOrderWithExtraCheeseAndHamGetDescription() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        pizzaOrder = new HamPizzaDecorator(pizzaOrder);
        // When
        String description = pizzaOrder.getDescription();

        // Then
        assertEquals("Pizza with cheese and tomato sauce + extra cheese + prosciutto di Parma", description);
    }

    @Test
    void testPizzaOrderWithExtraCheeseAndHamAndSalamiGetCost() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        pizzaOrder = new HamPizzaDecorator(pizzaOrder);
        pizzaOrder = new SalamiPizzaDecorator(pizzaOrder);
        // When
        BigDecimal cost = pizzaOrder.getCost();

        // Then
        assertEquals(new BigDecimal(35), cost);
    }

    @Test
    void testPizzaOrderWithExtraCheeseAndHamAndSalamiGetDescription() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        pizzaOrder = new HamPizzaDecorator(pizzaOrder);
        pizzaOrder = new SalamiPizzaDecorator(pizzaOrder);
        // When
        String description = pizzaOrder.getDescription();

        // Then
        assertEquals("Pizza with cheese and tomato sauce + extra cheese + prosciutto di Parma + salami", description);
    }

    @Test
    void testPizzaOrderWithExtraCheeseAndHamAndSalamiAndTunaGetCost() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        pizzaOrder = new HamPizzaDecorator(pizzaOrder);
        pizzaOrder = new SalamiPizzaDecorator(pizzaOrder);
        pizzaOrder = new TunaPizzaDecorator(pizzaOrder);
        // When
        BigDecimal cost = pizzaOrder.getCost();

        // Then
        assertEquals(new BigDecimal(42), cost);
    }

    @Test
    void testPizzaOrderWithExtraCheeseAndHamAndSalamiAndTunaGetDescription() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        pizzaOrder = new HamPizzaDecorator(pizzaOrder);
        pizzaOrder = new SalamiPizzaDecorator(pizzaOrder);
        pizzaOrder = new TunaPizzaDecorator(pizzaOrder);
        // When
        String description = pizzaOrder.getDescription();

        // Then
        assertEquals("Pizza with cheese and tomato sauce + extra cheese + prosciutto di Parma + salami + tuna", description);
    }
}
