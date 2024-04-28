package com.tribeadsapi.tribeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tribeadsapi.tribeads.models.User;
import com.tribeadsapi.tribeads.repository.ComunityRepository;
import com.tribeadsapi.tribeads.repository.CountryRepository;
import com.tribeadsapi.tribeads.repository.LanguageRepository;
import com.tribeadsapi.tribeads.repository.UserRepository;
import com.tribeadsapi.tribeads.request.CreateUserRequest;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    LanguageRepository languageRepository;

    @Autowired
    ComunityRepository comunityRepository;

    public User createUser(CreateUserRequest user) {

        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setGender(user.getGender());
        newUser.setYear(user.getYear());
        newUser.setBirthDate(user.getBirthDate());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        userRepository.save(newUser);

        return newUser;

    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public String deleteUser(Long userId) {
        userRepository.deleteById(userId);
        return "User deleted";
    }

}
