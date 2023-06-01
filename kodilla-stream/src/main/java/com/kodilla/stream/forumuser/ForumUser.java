package com.kodilla.stream.forumuser;

import java.time.*;

public final class ForumUser {
    private final int userid;
    private final String name;
    private final char sex;
    private final LocalDate birthDate;
    private final int postsCount;

    public ForumUser(final int userid, final String name, final char sex, final LocalDate birthDate, final int postsCount) {
        this.userid = userid;
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
        this.postsCount = postsCount;
    }

    public int getUserid() {
        return userid;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostsCount() {
        return postsCount;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", postsCount=" + postsCount +
                '}';
    }
}
