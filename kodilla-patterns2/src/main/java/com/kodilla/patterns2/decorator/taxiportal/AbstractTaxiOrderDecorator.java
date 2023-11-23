package com.kodilla.patterns2.decorator.taxiportal;

public abstract class AbstractTaxiOrderDecorator implements TaxiOrder {
    private final TaxiOrder taxiOrder;

    protected AbstractTaxiOrderDecorator(TaxiOrder taxiOrder) {
        this.taxiOrder = taxiOrder;
    }

    @Override
    public java.math.BigDecimal getCost() {
        return taxiOrder.getCost();
    }

    @Override
    public String getDescription() {
        return taxiOrder.getDescription();
    }
}
