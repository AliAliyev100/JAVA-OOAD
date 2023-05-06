package org.example;

import org.example.People.User;
import org.example.People.UserList;
public class Authentication {
    private String username;
    private String password;

    Authentication(String username, String password){
        this.password = password;
        this.username = username;
    }

    public User register(String username, String password){
            User newUser = new User(username,password);
            saveUser(newUser);
            return newUser;
    }

    private void saveUser(User user){
        UserList.userList.add(user);
    }
}
