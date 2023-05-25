package com.kodilla.testing.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.util.*;

@ExtendWith(MockitoExtension.class)
class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    @Test
    void testListBooksWithConditionsReturnList() {

        // Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    void testListBooksWithConditionMoreThan20() {

        // Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                .thenReturn(resultListOf40Books);

        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");

        // Then
        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    void testListBooksWithConditionFragmentShorterThan3() {

        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        // Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    // NEW TESTS
    @Test
    void testNoBooksBorrowed() {
        // Given
        LibraryUser user = new LibraryUser("John", "Smith", "3456");
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        when(libraryDatabaseMock.listBooksInHandsOf(user)).thenReturn(List.of());

        // When
        List<Book> borrowedBooks = bookLibrary.listBooksInHandsOf(user);

        // Then
        assertEquals(0, borrowedBooks.size());
    }

    @Test
    void testOneBookBorrowed() {
        // Given
        LibraryUser user = new LibraryUser("Jane", "Collins", "7654");
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        Book borrowedBook = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        when(libraryDatabaseMock.listBooksInHandsOf(user)).thenReturn(List.of(borrowedBook));

        // When
        List<Book> borrowedBooks = bookLibrary.listBooksInHandsOf(user);

        // Then
        assertEquals(1, borrowedBooks.size());
        assertEquals(borrowedBook, borrowedBooks.get(0));
    }

    @Test
    void testFiveBooksBorrowed() {
        // Given
        LibraryUser user = new LibraryUser("Tom", "Wilson", "3092");
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        Book book1 = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        Book book3 = new Book("1984", "George Orwell", 1949);
        Book book4 = new Book("Pride and Prejudice", "Jane Austen", 1813);
        Book book5 = new Book("The Catcher in the Rye", "J.D. Salinger", 1951);

        when(libraryDatabaseMock.listBooksInHandsOf(user)).thenReturn(List.of(book1, book2, book3, book4, book5));

        // When
        List<Book> borrowedBooks = bookLibrary.listBooksInHandsOf(user);

        // Then
        assertEquals(5, borrowedBooks.size());
        assertEquals(book1, borrowedBooks.get(0));
        assertEquals(book2, borrowedBooks.get(1));
        assertEquals(book3, borrowedBooks.get(2));
        assertEquals(book4, borrowedBooks.get(3));
        assertEquals(book5, borrowedBooks.get(4));
    }
}