package com.tribeadsapi.tribeads.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Node(labels = { "Comunity" })
public class Comunity {

    @Id
    @GeneratedValue
    private Long comunityId;

    @Property("comunity_name")
    private String comunityName;

    @Property("topic")
    private String topic;

}
