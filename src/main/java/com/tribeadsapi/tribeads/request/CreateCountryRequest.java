package com.tribeadsapi.tribeads.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCountryRequest {

    private String countryName;
    private String capital;
    private Integer population;

}
