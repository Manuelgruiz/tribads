package com.tribeadsapi.tribeads.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tribeadsapi.tribeads.models.Comunity;
import com.tribeadsapi.tribeads.request.CreateComunityRequest;
import com.tribeadsapi.tribeads.service.ComunityService;

@RestController
@RequestMapping("/api/comunity/")
public class ComunityController {

    @Autowired
    ComunityService comunityService;

    @PostMapping("/create")
    public Comunity createComunity(@RequestBody CreateComunityRequest comunity) {
        return comunityService.createComunity(comunity);
    }
}
