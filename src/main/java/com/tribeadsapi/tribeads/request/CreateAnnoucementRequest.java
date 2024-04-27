package com.tribeadsapi.tribeads.request;

import java.util.Date;
import java.util.List;

import com.tribeadsapi.tribeads.models.Comunity;
import com.tribeadsapi.tribeads.models.Country;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAnnoucementRequest {

    private String title;
    private Long revenue;
    private String sponsor;
    private Date datePosted;
    private Date dateExpired;
    private String description;
    private Country country;
    private List<Comunity> comunities;

}
