package com.tribeadsapi.tribeads.models;

import java.util.Date;
import java.util.List;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node(labels = { "User" })
public class User {

    @Id
    @GeneratedValue
    private Long userId;

    @Property("name")
    private String name;

    @Property("gender")
    private String gender;

    @Property("year")
    private Integer year;

    @Property("birth_date")
    private Date birthDate;

    @Property("email")
    private String email;

    @Property("password")
    private String password;

    @Relationship(type = "LIVED_IN", direction = Relationship.Direction.OUTGOING)
    private Country country;

    @Relationship(type = "SPEAKS", direction = Relationship.Direction.OUTGOING)
    private List<IsSpeakingRelation> languages;

    @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.OUTGOING)
    private List<IsBelongsToRelation> comunities;

    @Relationship(type = "FOLLOWS", direction = Relationship.Direction.OUTGOING)
    private List<User> followers;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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

    public List<IsSpeakingRelation> getLanguages() {
        return languages;
    }

    public void setLanguages(List<IsSpeakingRelation> languages) {
        this.languages = languages;
    }

    public List<IsBelongsToRelation> getComunities() {
        return comunities;
    }

    public void setComunities(List<IsBelongsToRelation> comunities) {
        this.comunities = comunities;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

}
