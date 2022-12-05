package org.example.service;

import org.example.exeption.MyException;
import org.example.model.User;

import java.util.List;

public interface ServiceUser {

    User addUser(User user);

    void deleteById(Long id);

    List<User> getAll();

    User getById(Long id) throws MyException;

    void deleteAll();

    User updateUser(User user);

}
