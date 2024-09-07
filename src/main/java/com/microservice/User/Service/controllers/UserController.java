package com.microservice.User.Service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.User.Service.entities.User;
import com.microservice.User.Service.services.UserService;

@RestController
@RequestMapping("users")
public class UserController {

   @Autowired
    private UserService userService;

      @PostMapping("/create")
      public ResponseEntity<User> createUser(@RequestBody User user){
          User user1 = userService.saveUser(user);
          return ResponseEntity.status(HttpStatus.CREATED).body(user1);
        //   return new ResponseEntity<User>(user1, HttpStatus.CREATED);
      }

      @GetMapping("/id/{id}")
      public ResponseEntity<User> getUser(@PathVariable String id){
          User user = userService.getUser(id);
          return new ResponseEntity<User>(user, HttpStatus.OK);
      }

      @GetMapping
      public ResponseEntity<List<User>> getAllUsers(){
         List<User> users = userService.getAlluser();
         return new ResponseEntity<List<User>>(users, HttpStatus.OK);
      }

      @DeleteMapping("id/{id}")
      public ResponseEntity<?> deleteUser(@PathVariable String id)
      {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
      }
}
