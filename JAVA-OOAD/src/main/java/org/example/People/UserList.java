package org.example.People;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserList {
    public static List<User> userList = new ArrayList<>(Arrays.asList(
            new User("user", "123456")));

    public static List<Admin> adminList = new ArrayList<>(Arrays.asList(
            new Admin("admin", "admin")));

}
