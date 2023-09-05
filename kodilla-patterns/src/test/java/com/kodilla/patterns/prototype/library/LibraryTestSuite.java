package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {

        // Given
        Library library = new Library("Library 1");
        Book book1 = new Book("Title 1", "Author 1", LocalDate.of(2021, 3, 10));
        Book book2 = new Book("Title 2", "Author 2", LocalDate.of(2022, 1, 2));
        Book book3 = new Book("Title 3", "Author 3", LocalDate.of(2023, 7, 20));
        Book book4 = new Book("Title 4", "Author 4", LocalDate.of(2020, 5, 8));
        Book book5 = new Book("Title 5", "Author 5", LocalDate.of(2019, 11, 11));

        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
        library.getBooks().add(book4);
        library.getBooks().add(book5);

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Library 2");
        } catch (CloneNotSupportedException e) {
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Library 3");
        } catch (CloneNotSupportedException e) {
        }

        //When
        library.getBooks().remove(book1);

        //Then
        Assert.assertEquals(4, library.getBooks().size());
        assert clonedLibrary != null;
        Assert.assertEquals(4, clonedLibrary.getBooks().size());
        assert deepClonedLibrary != null;
        Assert.assertEquals(5, deepClonedLibrary.getBooks().size());
        Assert.assertEquals(clonedLibrary.getBooks(), library.getBooks());
        Assert.assertNotEquals(deepClonedLibrary.getBooks(), library.getBooks());
    }

}
