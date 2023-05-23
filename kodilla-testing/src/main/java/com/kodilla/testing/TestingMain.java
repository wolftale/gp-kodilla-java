package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        int resultAdd = calculator.add(10, 6);
        if (resultAdd == 16) {
            System.out.println("Test OK");
        } else {
            System.out.println("Error!");
        }

        int resultSubtract = calculator.subtract(10, 6);
        if (resultSubtract == 4) {
            System.out.println("Test OK");
        } else {
            System.out.println("Error!");
        }
    }
}
