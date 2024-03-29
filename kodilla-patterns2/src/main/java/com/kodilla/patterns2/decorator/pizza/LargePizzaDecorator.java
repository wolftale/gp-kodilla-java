package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class LargePizzaDecorator extends AbstractPizzaOrderDecorator {

    public LargePizzaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().multiply(new BigDecimal(2));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + large size";
    }
}
