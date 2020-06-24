package com.bytesw.demo.bs.service;

import com.bytesw.demo.bs.dao.UserRepository;
import com.bytesw.demo.bs.eis.bo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bytesw.demo.bs.eis.bto.GreetingsResponse;
import com.bytesw.demo.bs.eis.bto.GreetingsResponseText;

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
    public GreetingsResponse getUserById(int id) {
        User user = this.userRepository.findOne(id);
        GreetingsResponse response = new GreetingsResponse();
        response.setIdentification(user.getIdentification());
        response.setName(user.getName());
        response.setLastname(user.getLastname());
        response.setBirthdate(user.getBirthdate());
        return response;
    }

    @Override
    public GreetingsResponseText createUser(int id,String identificacion, String name, String lastname, String birthdate) {
        User user = new User();
        user.setId(id);
        user.setIdentification(identificacion);
        user.setName(name);
        user.setLastname(lastname);
        user.setBirthdate(birthdate);
        userRepository.save(user);
        GreetingsResponseText response = new GreetingsResponseText();
        response.setResponse("Created");
        response.setMessage("Usuario creado correctamente");

        return response;
    }

    @Override
    public GreetingsResponseText updateUser(int id, String identificacion, String name, String lastname, String birthdate) {
        User user = userRepository.findOne(id);
        // crush the variables of the object found
        user.setIdentification(identificacion);
        user.setName(name);
        user.setLastname(lastname);
        user.setBirthdate(birthdate);
        userRepository.save(user);
        GreetingsResponseText response = new GreetingsResponseText();
        response.setResponse("Updated");
        response.setMessage("Usuario actualizado correctamente");

        return response;
    }

    @Override
    public GreetingsResponseText deleteUser(int id) {
        this.userRepository.delete(id);
        GreetingsResponseText response = new GreetingsResponseText();
        response.setResponse("Deleted");
        response.setMessage("Usuario eleminado correctamente");

        return response;
    }
}
