package com.tribeadsapi.tribeads.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tribeadsapi.tribeads.models.Comunity;
import com.tribeadsapi.tribeads.models.IsBelongsToRelation;
import com.tribeadsapi.tribeads.models.IsSpeakingRelation;
import com.tribeadsapi.tribeads.models.Language;
import com.tribeadsapi.tribeads.models.User;
import com.tribeadsapi.tribeads.request.CreateUserFollow;
import com.tribeadsapi.tribeads.request.CreateUserRequest;
import com.tribeadsapi.tribeads.service.ComunityService;
import com.tribeadsapi.tribeads.service.CountryService;
import com.tribeadsapi.tribeads.service.LanguageService;
import com.tribeadsapi.tribeads.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/user/")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    CountryService countryService;

    @Autowired
    ComunityService comunityService;

    @Autowired
    LanguageService languageService;

    @PostMapping("/create")
    public User createuser(@RequestBody CreateUserRequest user) {
        if (userService.getUserByEmail(user.getEmail()) != null) {
            return null;
        }
        return userService.createUser(user);
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/getUserByEmail/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @PatchMapping("/followUser")
    public User createFollow(@RequestBody CreateUserFollow request) {
        User user1 = userService.getUserById(request.getUserId1());
        User user2 = userService.getUserById(request.getUserId2());

        user1.getFollowers().add(user2);
        userService.save(user1);
        return user1;
    }

    @PatchMapping("/connectCountry/{userId}/{countryId}")
    public User connectCountry(@PathVariable Long userId, @PathVariable Long countryId) {
        User user = userService.getUserById(userId);
        user.setCountry(countryService.getCountryById(countryId));
        userService.save(user);
        return user;
    }

    @PatchMapping("/connectCommunity/{userId}/{communityId}")
    public User connectCommunity(@PathVariable Long userId, @PathVariable Long communityId) {
        User user = userService.getUserById(userId);
        Comunity comunity = comunityService.getComunityById(communityId);
        IsBelongsToRelation isBelongsTo = new IsBelongsToRelation();
        isBelongsTo.setComunity(comunity);
        isBelongsTo.setMarks(isBelongsTo.getMarks());
        user.getComunities().add(isBelongsTo);
        userService.save(user);
        return user;
    }

    @PatchMapping("/connectLenguage/{userId}/{languageId}")
    public User connectLenguage(@PathVariable Long userId, @PathVariable Long languageId) {
        User user = userService.getUserById(userId);
        Language language = languageService.getLanguageById(languageId);
        IsSpeakingRelation isSpeaking = new IsSpeakingRelation();
        isSpeaking.setLanguage(language);
        user.getLanguages().add(isSpeaking);
        userService.save(user);
        return user;
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/delete/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }
}
