package com.tribeadsapi.tribeads.models;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Node(labels = { "Language" })
public class Language {

    @Id
    @GeneratedValue
    private Long languageId;

    @Property("language_name")
    private String languageName;

    @Property("level")
    private Integer level;

}
