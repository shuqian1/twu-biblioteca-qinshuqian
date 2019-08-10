package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Role;
import com.twu.biblioteca.model.User;

import java.util.ArrayList;
import java.util.Arrays;

public class LoginService {
    ArrayList<User> userList = new ArrayList<>(Arrays.asList(new User("c00-0001","Bob","123456", Role.Customer,"bob@163.com","13000000000"),
            new User("c00-0002","Tom","123456",Role.Customer,"tom@163.com","13000000001"),
            new User("l00-0001","Alice","666666",Role.Librarian)));

    public boolean login(String id,String password){
        for (User user:userList){
            if(user.getUserId().equals(id) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public User getInfoById(String id){
        for (User user:userList){
            if(user.getUserId().equals(id)){
                return user;
            }
        }
        return null;
    }

}
