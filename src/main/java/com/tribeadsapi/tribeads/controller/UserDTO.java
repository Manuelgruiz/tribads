package com.tribeadsapi.tribeads.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.tribeadsapi.tribeads.models.Country;
import com.tribeadsapi.tribeads.models.IsBelongsToRelation;
import com.tribeadsapi.tribeads.models.IsSpeakingRelation;
import com.tribeadsapi.tribeads.models.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private Long userId;
    private String name;
    private String gender;
    private Integer year;
    private Date birthDate;
    private String email;
    private String password;
    private Country country;
    private List<IsSpeakingRelation> languages;
    private List<IsBelongsToRelation> comunities;
    private List<String> followers;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.gender = user.getGender();
        this.year = user.getYear();
        this.birthDate = user.getBirthDate();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.country = user.getCountry();
        this.languages = user.getLanguages();
        this.comunities = user.getComunities();
        this.followers = user.getFollowers().stream().map(User::getName).collect(Collectors.toList());
    }

}
