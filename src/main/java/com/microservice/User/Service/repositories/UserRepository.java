package com.microservice.User.Service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.User.Service.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    
    
}
