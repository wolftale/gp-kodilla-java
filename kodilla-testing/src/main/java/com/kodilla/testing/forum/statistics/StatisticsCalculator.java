package com.kodilla.testing.forum.statistics;

import java.util.List;


public class StatisticsCalculator {
    private int usersCount;
    private int postsCount;
    private int commentsCount;
    private double avgPostsPerUser;
    private double avgCommentsPerUser;
    private double avgCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {
        List<String> users = statistics.usersNames();
        this.usersCount = users.size();
        this.postsCount = statistics.postsCount();
        this.commentsCount = statistics.commentsCount();

        if (usersCount > 0) {
            this.avgPostsPerUser = (double) postsCount / usersCount;
            this.avgCommentsPerUser = (double) commentsCount / usersCount;
        } else {
            this.avgPostsPerUser = 0;
            this.avgCommentsPerUser = 0;
        }

        if (postsCount > 0) {
            this.avgCommentsPerPost = (double) commentsCount / postsCount;
        } else {
            this.avgCommentsPerPost = 0;
        }
    }

    public void showStatistics() {
        System.out.println("Users count: " + usersCount);
        System.out.println("Posts count: " + postsCount);
        System.out.println("Comments count: " + commentsCount);
        System.out.println("Average posts per user: " + avgPostsPerUser);
        System.out.println("Average comments per user: " + avgCommentsPerUser);
        System.out.println("Average comments per post: " + avgCommentsPerPost);
    }

    public int getUsersCount() {
        return usersCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public double getAvgPostsPerUser() {
        return avgPostsPerUser;
    }

    public double getAvgCommentsPerUser() {
        return avgCommentsPerUser;
    }

    public double getAvgCommentsPerPost() {
        return avgCommentsPerPost;
    }
}
