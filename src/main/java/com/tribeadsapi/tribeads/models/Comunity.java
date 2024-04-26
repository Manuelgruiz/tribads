package com.tribeadsapi.tribeads.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node(labels = { "Comunity" })
public class Comunity {

    @Id
    @GeneratedValue
    private Long comunityId;

    @Property("comunity_name")
    private String comunityName;

    @Property("topic")
    private String topic;

    public Long getComunityId() {
        return comunityId;
    }

    public void setComunityId(Long comunityId) {
        this.comunityId = comunityId;
    }

    public String getComunityName() {
        return comunityName;
    }

    public void setComunityName(String comunityName) {
        this.comunityName = comunityName;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

}
