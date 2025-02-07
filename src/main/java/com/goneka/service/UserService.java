package com.goneka.service;

import com.goneka.exception.UserException;
import com.goneka.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id) throws UserException;
    List<User> getAllUsers();
    User updateUser(Long id, User user) throws UserException;
    void deleteUser(Long id) throws UserException;

}
