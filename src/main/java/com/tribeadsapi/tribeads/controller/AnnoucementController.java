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

import com.tribeadsapi.tribeads.models.Annoucement;
import com.tribeadsapi.tribeads.request.CreateAnnoucementRequest;
import com.tribeadsapi.tribeads.request.GetAnnoucementByCreationDate;
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

    @GetMapping("getByTitle/{title}")
    public Annoucement getAnnoucementByTitle(@PathVariable String title) {
        return annoucementService.getAnnoucementByTitle(title);
    }

    @GetMapping("getAllAnnoucements")
    public List<Annoucement> getAllAnnoucements() {
        return annoucementService.getAllAnnoucements();
    }

    @GetMapping("/getAnnoucementByDate")
    public List<Annoucement> getMethodName(@RequestBody GetAnnoucementByCreationDate dates) {
        return annoucementService.getAnnoucementByDates(dates);
    }

    @DeleteMapping("/deleteAnnoucement/{annoucementId}")
    public String deleteAnnoucement(@PathVariable Long annoucementId) {
        return annoucementService.deleteAnnoucement(annoucementId);
    }

}
