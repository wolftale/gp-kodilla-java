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

        switch (difficulty) {
            case "easy":
                if (random.nextInt(100) < 30) {
                    return getWinningMove();
                } else {
                    return choices[random.nextInt(choices.length)];
                }
            case "hard":
                if (random.nextInt(100) < 70) {
                    return getWinningMove();
                } else {
                    return choices[random.nextInt(choices.length)];
                }
            default:
                return choices[random.nextInt(choices.length)];
        }
    }

    private String getWinningMove() {
        String[] winningMoves = {"paper", "scissors", "rock", "spock", "lizard"};
        return winningMoves[random.nextInt(winningMoves.length)];
    }
}
