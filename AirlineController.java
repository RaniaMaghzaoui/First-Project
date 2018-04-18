package com.whs.wcdm.controller;

import com.whs.wcdm.pojo.Address;
import com.whs.wcdm.pojo.Airline;
import com.whs.wcdm.pojo.User;
import com.whs.wcdm.repository.AddressRepository;
import com.whs.wcdm.repository.AirlineRepository;
import com.whs.wcdm.repository.UserRepository;
import com.whs.wcdm.service.UniqueIDTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by oem on 10/03/17.
 */
@RestController
@RequestMapping("/wcdm/register")
public class AirlineController {
    @Autowired
    AirlineRepository airlineRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressRepository adressRepository;

    @Autowired
    UniqueIDTest uniqueIDTest;

    @CrossOrigin
    @RequestMapping( method = RequestMethod.POST)

    public Airline createAirline(@Valid @RequestBody Airline airline ) {

      Address a= adressRepository.save(airline.getAddress());
       airline.setAddress((a));
      User u  =  userRepository.save(airline.getUser());
      u.setEnable(false);
        u.addRole("airline");
         airline.setUser((u));
        airline.setIataCode(uniqueIDTest.getU().toString());
        return this.airlineRepository.save(airline);
    }
}
