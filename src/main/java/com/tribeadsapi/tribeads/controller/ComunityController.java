package com.tribeadsapi.tribeads.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("getByName/{name}")
    public Comunity getComunityByName(@PathVariable String name) {
        return comunityService.getComunityByName(name);
    }

    @GetMapping("getAllComunities")
    public List<Comunity> getAllComunities() {
        return comunityService.getAllComunities();
    }

    @DeleteMapping("/deleteComunity/{comunityId}")
    public String deleteComunity(@PathVariable Long comunityId) {
        return comunityService.deleteComunity(comunityId);
    }

    @GetMapping("/getComunityWithMostUsers")
    public Comunity getComunityWithMostUsers() {
        return comunityService.getComunityWithMostUsers();
    }

}
