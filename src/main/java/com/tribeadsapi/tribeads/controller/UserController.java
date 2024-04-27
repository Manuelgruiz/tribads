package com.tribeadsapi.tribeads.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tribeadsapi.tribeads.models.User;
import com.tribeadsapi.tribeads.request.CreateUserFollow;
import com.tribeadsapi.tribeads.request.CreateUserRequest;
import com.tribeadsapi.tribeads.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/user/")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public User createuser(@RequestBody CreateUserRequest user) {
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

    @PostMapping("/followUser")
    public User createFollow(@RequestBody CreateUserFollow request) {
        User user1 = userService.getUserById(request.getUserId1());
        User user2 = userService.getUserById(request.getUserId2());

        user1.getFollowers().add(user2);
        userService.save(user1);
        return user1;
    }

    @DeleteMapping("/delete/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }
}
