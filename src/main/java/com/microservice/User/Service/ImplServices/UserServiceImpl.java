package com.microservice.User.Service.ImplServices;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.User.Service.Exceptions.ResourceNotFoundException;
import com.microservice.User.Service.entities.User;
import com.microservice.User.Service.repositories.UserRepository;
import com.microservice.User.Service.services.UserService;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
     private UserRepository userRepository;

    @Override
    public List<User> getAlluser() {
       return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {

       return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user with given id is not found on server !!" + userId));

        // Optional optional =  userRepository.findById(userId);

        // if(optional.isPresent())
        // {
        //     User user = (User) optional.get();
        //     return user;
        // }
        // return null;
    }

    @Override
    public User saveUser(User user) {
       String randomId  = UUID.randomUUID().toString();
       user.setUserId(randomId);
       return userRepository.save(user);
    }

   @Override
   public void deleteUser(String id) {
     userRepository.deleteById(id);
   }

   @Override
   public User updateUser(User user) {
      return null;
   }
}
