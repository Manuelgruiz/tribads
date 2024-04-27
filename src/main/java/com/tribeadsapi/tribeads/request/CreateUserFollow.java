package com.tribeadsapi.tribeads.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserFollow {

    private Long userId1;
    private Long userId2;

}
