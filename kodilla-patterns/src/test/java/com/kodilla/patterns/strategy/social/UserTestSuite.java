package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {

        //Given
        User greg = new Millenials("John");
        User kate = new YGeneration("Mary");
        User john = new ZGeneration("Eryn");

        //When and Then
        Assertions.assertEquals("[FacebookPublisher]", greg.sharePost());
        Assertions.assertEquals("[TwitterPublisher]", kate.sharePost());
        Assertions.assertEquals("[SnapchatPublisher]", john.sharePost());
    }

    @Test
    public void testIndividualSharingStrategy() {

        //Given
        User greg = new Millenials("John");
        User kate = new YGeneration("Mary");
        User john = new ZGeneration("Eryn");

        //When
        john.setSocialPublisher(new SnapchatPublisher());

        //Then
        Assertions.assertEquals("[FacebookPublisher]", greg.sharePost());
        Assertions.assertEquals("[TwitterPublisher]", kate.sharePost());
        Assertions.assertEquals("[SnapchatPublisher]", john.sharePost());
    }
}
