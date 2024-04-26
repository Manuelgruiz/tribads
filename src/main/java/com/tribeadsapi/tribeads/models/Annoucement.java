package com.tribeadsapi.tribeads.models;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

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

    public Long getAnnoucementId() {
        return annoucementId;
    }

    public void setAnnoucementId(Long annoucementId) {
        this.annoucementId = annoucementId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getRevenue() {
        return revenue;
    }

    public void setRevenue(Long revenue) {
        this.revenue = revenue;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public Date getDateExpired() {
        return dateExpired;
    }

    public void setDateExpired(Date dateExpired) {
        this.dateExpired = dateExpired;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<IsTargetRelation> getComunities() {
        return comunities;
    }

    public void setComunities(List<IsTargetRelation> comunities) {
        this.comunities = comunities;
    }

}
