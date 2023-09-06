package com.smk.cashier.service;

import com.smk.cashier.model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class UserService {
    FileWriter userServiceWriter;
    FileReader userServiceReader;
    List<User> userList = new LinkedList<>();
    private static UserService userService = null;
    private UserService() {
        try {
            userServiceWriter = new FileWriter("user.txt");
            userServiceReader = new FileReader("user.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static synchronized UserService getInstance() {
        if(userService == null)
            userService = new UserService();
        return userService;
    }

    private void readFile(){
        BufferedReader bufferedReader = new BufferedReader(userServiceReader);

    }
}
