package com.tribeadsapi.tribeads.models;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RelationshipProperties
public class IsSpeakingRelation {

    @Id
    @GeneratedValue
    private Long marks;

    @TargetNode
    private Language language;

}
