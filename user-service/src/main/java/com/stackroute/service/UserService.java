package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exception.UserAlreadyExistException;

import java.util.List;

public interface UserService {


    User saveUser(User user) throws UserAlreadyExistException;

    List<User> getAllUser();
}
