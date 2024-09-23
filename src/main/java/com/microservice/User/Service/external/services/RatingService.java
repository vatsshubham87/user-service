package com.microservice.User.Service.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.User.Service.entities.Rating;

@FeignClient(name="Rating-Service")
public interface RatingService {

    @GetMapping("/ratings/users/{userId}")
    List<Rating> getRating(@PathVariable String userId);
}
