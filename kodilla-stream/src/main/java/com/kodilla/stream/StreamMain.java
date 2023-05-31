package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {

    public static void main(String[] args) {
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        PoemBeautifier beautifier = new PoemBeautifier();

        // Upiększacz: dodanie "ABC" na początku i na końcu tekstu
        beautifier.beautify("Lorem ipsum quam viverra orci sagittis", text -> "ABC_" + text + "_ABC");

        // Upiększacz: zmiana tekstu na duże litery
        beautifier.beautify("Lorem ipsum quam viverra orci sagittis", String::toUpperCase);

        // Własny upiększacz: odwrócenie tekstu
        beautifier.beautify("Lorem ipsum quam viverra orci sagittis", text -> {
            StringBuilder reversedText = new StringBuilder(text);
            return reversedText.reverse().toString();
        });

        // Własny upiększacz: zamiana liter 'a' na 'z'
        beautifier.beautify("Lorem ipsum quam viverra orci sagittis", text -> text.replace('m', 'M'));

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);

    }
}
