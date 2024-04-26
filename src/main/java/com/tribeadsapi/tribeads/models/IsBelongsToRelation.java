package com.tribeadsapi.tribeads.models;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
public class IsBelongsToRelation {

    @Id
    @GeneratedValue
    private Long marks;

    @TargetNode
    private Comunity comunity;

    public Long getMarks() {
        return marks;
    }

    public void setMarks(Long marks) {
        this.marks = marks;
    }

    public Comunity getComunity() {
        return comunity;
    }

    public void setComunity(Comunity comunity) {
        this.comunity = comunity;
    }

}
