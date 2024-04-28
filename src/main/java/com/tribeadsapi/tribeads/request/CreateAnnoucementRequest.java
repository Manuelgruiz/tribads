package com.tribeadsapi.tribeads.request;

import java.util.Date;

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

}
