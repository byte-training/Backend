package com.bytesw.demo.bs.service;

import com.bytesw.demo.bs.eis.bo.User;

import java.util.ArrayList;

public interface GreetingsService {

    ArrayList getUser();

    User getUserById(int id);

    void createUser(int id,String identificacion, String name, String lastname, String birthdate);

    void updateUser(int id,String identificacion, String name, String lastname, String birthdate);

    void deleteUser(int id);
}
