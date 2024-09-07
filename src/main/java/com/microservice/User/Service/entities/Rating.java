package com.microservice.User.Service.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

   private String RatingId;
   private String userId;
   private String HotelId;
   private int rating;
   private String feedback;

}
