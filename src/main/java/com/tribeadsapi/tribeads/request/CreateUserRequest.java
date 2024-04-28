package com.tribeadsapi.tribeads.request;

import java.util.Date;
import java.util.List;

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
    private List<CreateLanguageRequest> languages;

}
