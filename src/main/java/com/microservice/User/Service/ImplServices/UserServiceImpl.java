package com.microservice.User.Service.ImplServices;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.User.Service.Exceptions.ResourceNotFoundException;
import com.microservice.User.Service.entities.Hotel;
import com.microservice.User.Service.entities.Rating;
import com.microservice.User.Service.entities.User;
import com.microservice.User.Service.external.services.HotelService;
import com.microservice.User.Service.external.services.RatingService;
import com.microservice.User.Service.repositories.UserRepository;
import com.microservice.User.Service.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

   @Autowired
   RestTemplate restTemplate;

   @Autowired
   HotelService hotelService;

   @Autowired 
   RatingService ratingService;


    @Autowired
     private UserRepository userRepository;

    @Override
    public List<User> getAlluser() {
       return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {

       User user = userRepository.findById(userId).orElseThrow(()-> new 
       ResourceNotFoundException("user with given id is not found on server !!" + userId));

      // Rating[] ratingOfUser =  restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), 
      // Rating[].class);

      // Rating[] ratingOfUser = ratingService.getRating(user.getUserId());

      List<Rating> ratings = ratingService.getRating(user.getUserId());

      //  List<Rating> ratings = Arrays.stream(ratingOfUser).toList();

       log.info("{}", ratings);
       
      List<Rating> ratingList = ratings.stream().map( rating -> {

      // ResponseEntity<Hotel> hotelEntity =  restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/id/"+rating.getHotelId()
      // , Hotel.class);

      // Hotel hotel = hotelEntity.getBody();

      Hotel hotel = hotelService.getHotel(rating.getHotelId());

      // log.info("status" + hotelEntity.getStatusCode());

      rating.setHotel(hotel);

      return rating;
      
      }).toList();

       user.setRatings(ratingList);


       return user;
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
