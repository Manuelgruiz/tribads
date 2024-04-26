package com.tribeadsapi.tribeads.request;

import java.util.Date;
import java.util.List;

import com.tribeadsapi.tribeads.models.Comunity;
import com.tribeadsapi.tribeads.models.Country;

public class CreateAnnoucementRequest {

    private String title;
    private Long revenue;
    private String sponsor;
    private Date datePosted;
    private Date dateExpired;
    private String description;
    private Country country;
    private List<Comunity> comunities;

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

    public List<Comunity> getComunities() {
        return comunities;
    }

    public void setComunities(List<Comunity> comunities) {
        this.comunities = comunities;
    }

}
