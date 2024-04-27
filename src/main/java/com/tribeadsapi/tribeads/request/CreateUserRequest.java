package com.tribeadsapi.tribeads.request;

import java.util.Date;
import java.util.List;

import com.tribeadsapi.tribeads.models.Country;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {

    private String name;
    private String gender;
    private Integer year;
    private Date birthDate;
    private String email;
    private String password;
    private Country country;
    private List<CreateLanguageRequest> languages;
    private List<CreateComunityRequest> comunities;

}
