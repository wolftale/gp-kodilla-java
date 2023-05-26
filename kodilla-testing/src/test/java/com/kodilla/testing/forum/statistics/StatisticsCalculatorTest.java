package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class StatisticsCalculatorTest {
    private Statistics statistics;
    private StatisticsCalculator calculator;

    @BeforeEach
    public void setup() {
        statistics = Mockito.mock(Statistics.class);
        calculator = new StatisticsCalculator();
    }

    @Test
    public void testZeroPosts() {
        when(statistics.usersNames()).thenReturn(Arrays.asList("User1", "User2"));
        when(statistics.postsCount()).thenReturn(0);
        when(statistics.commentsCount()).thenReturn(100);

        calculator.calculateAdvStatistics(statistics);

        assertEquals(0, calculator.getPostsCount());
        assertEquals(100, calculator.getCommentsCount());
        assertEquals(0, calculator.getAvgPostsPerUser());
        assertEquals(50, calculator.getAvgCommentsPerUser());
        assertEquals(0, calculator.getAvgCommentsPerPost());
    }

    @Test
    public void test1000Posts() {
        when(statistics.usersNames()).thenReturn(Arrays.asList("User1", "User2", "User3"));
        when(statistics.postsCount()).thenReturn(1000);
        when(statistics.commentsCount()).thenReturn(500);

        calculator.calculateAdvStatistics(statistics);

        assertEquals(1000, calculator.getPostsCount());
        assertEquals(500, calculator.getCommentsCount());
        assertEquals(333.33, calculator.getAvgPostsPerUser(), 0.01);
        assertEquals(166.67, calculator.getAvgCommentsPerUser(), 0.01);
        assertEquals(0.5, calculator.getAvgCommentsPerPost(), 0.01);
    }

    @Test
    public void testZeroComments() {
        when(statistics.usersNames()).thenReturn(Arrays.asList("User1", "User2", "User3"));
        when(statistics.postsCount()).thenReturn(100);
        when(statistics.commentsCount()).thenReturn(0);

        calculator.calculateAdvStatistics(statistics);

        assertEquals(100, calculator.getPostsCount());
        assertEquals(0, calculator.getCommentsCount());
        assertEquals(33.33, calculator.getAvgPostsPerUser(), 0.01);
        assertEquals(0, calculator.getAvgCommentsPerUser());
        assertEquals(0, calculator.getAvgCommentsPerPost());
    }

    @Test
    public void testCommentsLessThanPosts() {
        when(statistics.usersNames()).thenReturn(Arrays.asList("User1", "User2"));
        when(statistics.postsCount()).thenReturn(100);
        when(statistics.commentsCount()).thenReturn(50);

        calculator.calculateAdvStatistics(statistics);

        assertEquals(100, calculator.getPostsCount());
        assertEquals(50, calculator.getCommentsCount());
        assertEquals(50, calculator.getAvgPostsPerUser());
        assertEquals(25, calculator.getAvgCommentsPerUser());
        assertEquals(0.5, calculator.getAvgCommentsPerPost());
    }

    @Test
    public void testCommentsGreaterThanPosts() {
        when(statistics.usersNames()).thenReturn(Arrays.asList("User1", "User2", "User3"));
        when(statistics.postsCount()).thenReturn(100);
        when(statistics.commentsCount()).thenReturn(150);

        calculator.calculateAdvStatistics(statistics);

        assertEquals(100, calculator.getPostsCount());
        assertEquals(150, calculator.getCommentsCount());
        assertEquals(33.33, calculator.getAvgPostsPerUser(), 0.01);
        assertEquals(50, calculator.getAvgCommentsPerUser());
        assertEquals(1.5, calculator.getAvgCommentsPerPost(), 0.01);
    }

    @Test
    public void testZeroUsers() {
        when(statistics.usersNames()).thenReturn(Arrays.asList());
        when(statistics.postsCount()).thenReturn(100);
        when(statistics.commentsCount()).thenReturn(50);

        calculator.calculateAdvStatistics(statistics);

        assertEquals(100, calculator.getPostsCount());
        assertEquals(50, calculator.getCommentsCount());
        assertEquals(0, calculator.getAvgPostsPerUser());
        assertEquals(0, calculator.getAvgCommentsPerUser());
        assertEquals(0.5, calculator.getAvgCommentsPerPost());
    }

    @Test
    public void test100Users() {
        when(statistics.usersNames()).thenReturn(Arrays.asList(
                "User1", "User2", "User3", "User4", "User5", "User6", "User7", "User8", "User9", "User10",
                "User11", "User12", "User13", "User14", "User15", "User16", "User17", "User18", "User19", "User20",
                "User21", "User22", "User23", "User24", "User25", "User26", "User27", "User28", "User29", "User30",
                "User31", "User32", "User33", "User34", "User35", "User36", "User37", "User38", "User39", "User40",
                "User41", "User42", "User43", "User44", "User45", "User46", "User47", "User48", "User49", "User50",
                "User51", "User52", "User53", "User54", "User55", "User56", "User57", "User58", "User59", "User60",
                "User61", "User62", "User63", "User64", "User65", "User66", "User67", "User68", "User69", "User70",
                "User71", "User72", "User73", "User74", "User75", "User76", "User77", "User78", "User79", "User80",
                "User81", "User82", "User83", "User84", "User85", "User86", "User87", "User88", "User89", "User90",
                "User91", "User92", "User93", "User94", "User95", "User96", "User97", "User98", "User99", "User100"
        ));
        when(statistics.postsCount()).thenReturn(1000);
        when(statistics.commentsCount()).thenReturn(500);

        calculator.calculateAdvStatistics(statistics);

        assertEquals(1000, calculator.getPostsCount());
        assertEquals(500, calculator.getCommentsCount());
        assertEquals(10, calculator.getAvgPostsPerUser());
        assertEquals(5, calculator.getAvgCommentsPerUser());
        assertEquals(0.5, calculator.getAvgCommentsPerPost());
    }
}
