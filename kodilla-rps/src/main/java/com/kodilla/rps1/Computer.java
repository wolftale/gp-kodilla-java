package com.kodilla.rps1;

import java.util.Random;

public class Computer {
    private String difficulty;
    private Random random;

    public Computer(String difficulty) {
        this.difficulty = difficulty;
        this.random = new Random();
    }

    public String makeMove() {
        String[] choices = {"rock", "paper", "scissors", "lizard", "spock"};

        if (difficulty.equals("easy")) {
            return choices[random.nextInt(choices.length)];
        } else if (difficulty.equals("normal")) {
            int randomIndex = random.nextInt(choices.length - 2);
            return choices[randomIndex];
        } else {
            int randomIndex = random.nextInt(choices.length);
            return choices[randomIndex];
        }
    }
}


