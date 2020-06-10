package com.bytesw.demo.bs.service;

import com.bytesw.demo.bs.dao.UserRepository;
import com.bytesw.demo.bs.eis.bo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GreetingsServiceImpl implements GreetingsService{

    private final UserRepository userRepository;

    @Autowired
    public GreetingsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public ArrayList getUser() {
        ArrayList user = (ArrayList) this.userRepository.findAll();
        return user;
    }

    @Override
    public User getUserById(int id) {
        User user = this.userRepository.findOne(id);
        return user;
    }

    @Override
    public void createUser(int id,String identificacion, String name, String lastname, String birthdate) {
        User user = new User();
        user.setId(id);
        user.setIdentification(identificacion);
        user.setName(name);
        user.setLastname(lastname);
        user.setBirthdate(birthdate);
        userRepository.save(user);
    }

    @Override
    public void updateUser(int id, String identificacion, String name, String lastname, String birthdate) {
        User user = userRepository.findOne(id);
        // crush the variables of the object found
        user.setIdentification(identificacion);
        user.setName(name);
        user.setLastname(lastname);
        user.setBirthdate(birthdate);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        this.userRepository.delete(id);
    }
}
