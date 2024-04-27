package com.tribeadsapi.tribeads.models;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Node(labels = { "Country" })
public class Country {

    @Id
    @GeneratedValue
    private Long countryId;

    @Property("country_name")
    private String countryName;

    @Property("capital")
    private String capital;

    @Property("population")
    private Integer Population;

}
