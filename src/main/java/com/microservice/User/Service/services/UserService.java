package com.microservice.User.Service.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.User.Service.entities.User;

@Service
public interface UserService {

    public User saveUser(User user);

    public List<User> getAlluser();

    public User getUser(String UserId);

    public void deleteUser(String id);
    
    public User updateUser(User user);
    
}
