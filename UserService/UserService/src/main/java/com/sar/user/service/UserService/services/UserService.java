package com.sar.user.service.UserService.services;

import com.sar.user.service.UserService.entities.User;

import java.util.List;

public interface UserService {

    //user operations

    //create
    public User saveUser(User user);

    //get all users
    public List<User> getAllUsers();

    //get single user of given userId
    public User getUser(String userId);

    //update user with given userId
    public User updateUser(User user);

    //delete user with given userId
    public void deleteUser(String userId);

}
