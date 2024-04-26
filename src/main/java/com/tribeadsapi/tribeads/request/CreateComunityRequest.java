package com.tribeadsapi.tribeads.request;

public class CreateComunityRequest {
    private String comunityName;
    private String topic;

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
