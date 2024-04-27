package com.tribeadsapi.tribeads.request;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAnnoucementByCreationDate {

    private List<Date> datesPosted;

}
