package com.tribeadsapi.tribeads.models;

import java.util.Date;
import java.util.List;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

}
