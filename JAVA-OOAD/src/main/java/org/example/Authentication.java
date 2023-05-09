package org.example;

import org.example.People.User;
import org.example.People.UserList;
public class Authentication {

    public static User register(String username, String password){
            User newUser = new User(username,password);
            saveUser(newUser);
            return newUser;
    }

    public static User login(String username, String password){
        User user;
        for (int i = 0; i < UserList.userList.size(); i++) {
            User currentUser = UserList.userList.get(i);
            if(currentUser.getUsername().equals(username) && currentUser.getPassword().equals(password)){
                user = currentUser;
                return user;
            }
        }
        for (int i = 0; i < UserList.adminList.size(); i++) {
            System.out.println("checking");
            User currentUser = UserList.adminList.get(i);
            System.out.println("Currentuser: " + currentUser.getUsername());
            if(currentUser.getUsername().equals(username) && currentUser.getPassword().equals(password)){
                user = currentUser;
                return user;
            }
        }

        System.out.println("No user found!");
        return null;
    }

    private static void saveUser(User user){
        UserList.userList.add(user);
    }
}
