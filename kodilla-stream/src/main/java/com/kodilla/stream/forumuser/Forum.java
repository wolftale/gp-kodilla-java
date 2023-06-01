package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> UserList = new ArrayList<>();

    public Forum() {
        UserList.add(new ForumUser(1, "John Smith", 'M', LocalDate.of(1980,5,12), 100));
        UserList.add(new ForumUser(2, "Emma Ruell", 'F', LocalDate.of(2008,9,1), 20));
        UserList.add(new ForumUser(3, "Osbert Geis", 'M', LocalDate.of(1977,2,22), 280));
        UserList.add(new ForumUser(4, "Harrison Potter", 'M', LocalDate.of(1987,6,17), 87));
        UserList.add(new ForumUser(5, "Adele Alvarez", 'F', LocalDate.of(2005,4,26), 31));
        UserList.add(new ForumUser(6, "Beatrice Mills", 'F', LocalDate.of(1994,10,11), 302));
        UserList.add(new ForumUser(7, "Victor Abbott", 'M', LocalDate.of(1973,3,3), 147));
        UserList.add(new ForumUser(8, "Eddie Simon", 'M', LocalDate.of(2003,12,20), 95));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(UserList);
    }
}
