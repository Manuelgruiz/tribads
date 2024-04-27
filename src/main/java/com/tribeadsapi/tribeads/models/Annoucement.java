package com.tribeadsapi.tribeads.models;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Node(labels = { "Annoucement" })
public class Annoucement {

    @Id
    @GeneratedValue
    private Long annoucementId;

    @Property("title")
    private String title;

    @Property("revenue")
    private Long revenue;

    @Property("sponsor")
    private String sponsor;

    @Property("date_posted")
    private Date datePosted;

    @Property("date_expired")
    private Date dateExpired;

    @Property("description")
    private String description;

    @Relationship(type = "EMITED_IN", direction = Relationship.Direction.OUTGOING)
    private Country country;

    @Relationship(type = "TARGET_TO", direction = Relationship.Direction.OUTGOING)
    private List<IsTargetRelation> comunities;

}
