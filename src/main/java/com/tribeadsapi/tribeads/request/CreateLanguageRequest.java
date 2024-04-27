package com.tribeadsapi.tribeads.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateLanguageRequest {

    private String languageName;
    private Integer level;

}
