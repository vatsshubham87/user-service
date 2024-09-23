package com.microservice.User.Service.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.User.Service.entities.Hotel;

@FeignClient(name="Hotel-Service")
public interface HotelService {

    @GetMapping("/hotels/id/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);

}
