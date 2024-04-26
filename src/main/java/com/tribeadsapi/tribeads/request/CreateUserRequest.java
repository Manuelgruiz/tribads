package com.tribeadsapi.tribeads.request;

import java.util.Date;
import java.util.List;

import com.tribeadsapi.tribeads.models.Country;

public class CreateUserRequest {

    private String name;
    private String gender;
    private Integer year;
    private Date birthDate;
    private String email;
    private String password;
    private Country country;
    private List<CreateLanguageRequest> languages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<CreateLanguageRequest> getLanguages() {
        return languages;
    }

    public void setLanguages(List<CreateLanguageRequest> languages) {
        this.languages = languages;
    }

}
