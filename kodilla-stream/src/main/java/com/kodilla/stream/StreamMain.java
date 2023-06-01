package com.kodilla.stream;

import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import java.util.*;
import java.time.LocalDate;
import java.util.stream.Collectors;


public class StreamMain {

    public static void main(String[] args) {
        /*BookDirectory theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()  // [1]
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));                    // [2]

        System.out.println(theResultStringOfBooks);*/

        Forum forum = new Forum();

        Map<Integer, ForumUser> filteredUser = forum.getUserList().stream()
                .filter(ForumUser -> ForumUser.getSex() == 'M')
                .filter(ForumUser -> ForumUser.getBirthDate().isBefore(LocalDate.now().minusYears(19)))
                .filter(ForumUser -> ForumUser.getPostsCount() > 0)
                .collect(Collectors.toMap(ForumUser::getUserid, ForumUser -> ForumUser));

        System.out.println("Filtered Users: " + filteredUser.size());
        filteredUser.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

    }
}
