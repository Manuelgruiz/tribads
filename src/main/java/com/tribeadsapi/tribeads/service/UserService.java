package com.tribeadsapi.tribeads.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tribeadsapi.tribeads.models.Country;
import com.tribeadsapi.tribeads.models.User;
import com.tribeadsapi.tribeads.repository.CountryRepository;
import com.tribeadsapi.tribeads.repository.UserRepository;
import com.tribeadsapi.tribeads.request.CreateUserRequest;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    CountryRepository countryRepository;

    public User createUser(CreateUserRequest user) {
        Country country = new Country();
        country.setCountryName(user.getCountry().getCountryName());
        country.setCapital(user.getCountry().getCapital());
        country.setPopulation(user.getCountry().getPopulation());
        countryRepository.save(country);

        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setGender(user.getGender());
        newUser.setYear(user.getYear());
        newUser.setBirthDate(user.getBirthDate());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setCountry(country);
        userRepository.save(newUser);

        return newUser;

    }

}
