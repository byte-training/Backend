package com.bytesw.demo.bs.service;

import com.bytesw.demo.bs.eis.bo.User;
import com.bytesw.demo.bs.eis.bto.GreetingsResponse;
import com.bytesw.demo.bs.eis.bto.GreetingsResponseText;

import java.util.ArrayList;

public interface GreetingsService {

    ArrayList getUser();

    GreetingsResponse getUserById(int id);

    GreetingsResponseText createUser(int id,String identificacion, String name, String lastname, String birthdate);

    GreetingsResponseText updateUser(int id,String identificacion, String name, String lastname, String birthdate);

    GreetingsResponseText deleteUser(int id);
}
