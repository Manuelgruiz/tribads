package com.tribeadsapi.tribeads.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tribeadsapi.tribeads.models.Annoucement;
import com.tribeadsapi.tribeads.request.CreateAnnoucementRequest;
import com.tribeadsapi.tribeads.service.AnnoucementService;

@RestController
@RequestMapping("/api/annoucement/")
public class AnnoucementController {
    @Autowired
    AnnoucementService annoucementService;

    @PostMapping("/create")
    public Annoucement createAnnoucement(@RequestBody CreateAnnoucementRequest annoucement) {
        return annoucementService.createAnnoucement(annoucement);
    }

}
