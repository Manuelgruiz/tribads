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
import com.tribeadsapi.tribeads.models.Comunity;
import com.tribeadsapi.tribeads.models.IsTargetRelation;
import com.tribeadsapi.tribeads.request.CreateAnnoucementRequest;
import com.tribeadsapi.tribeads.request.GetAnnoucementByCreationDate;
import com.tribeadsapi.tribeads.service.AnnoucementService;
import com.tribeadsapi.tribeads.service.ComunityService;
import com.tribeadsapi.tribeads.service.CountryService;

@RestController
@RequestMapping("/api/annoucement/")
public class AnnoucementController {
    @Autowired
    AnnoucementService annoucementService;

    @Autowired
    CountryService countryService;

    @Autowired
    ComunityService comunityService;

    @PostMapping("/create")
    public Annoucement createAnnoucement(@RequestBody CreateAnnoucementRequest annoucement) {
        if (annoucementService.getAnnoucementByTitle(annoucement.getTitle()) != null) {
            return null;
        }
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

    @PostMapping("/connectCountryToAnnoucement/{annoucementId}/{countryId}")
    public Annoucement connenctCountryToAnnoucement(Long annoucementId, Long countryId) {
        Annoucement annoucement = annoucementService.getAnnoucementById(annoucementId);
        annoucement.setCountry(countryService.getCountryById(countryId));
        annoucementService.save(annoucement);
        return annoucement;
    }

    @PostMapping("/connectCommunityToAnnoucement/{annoucementId}/{comunityId}")
    public Annoucement connectCommunityToAnnoucement(Long annoucementId, Long comunityId) {
        Annoucement annoucement = annoucementService.getAnnoucementById(annoucementId);
        Comunity comunity = comunityService.getComunityById(comunityId);
        IsTargetRelation isTarget = new IsTargetRelation();
        isTarget.setComunity(comunity);
        isTarget.setMarks(isTarget.getMarks());
        annoucement.getComunities().add(isTarget);
        annoucementService.save(annoucement);
        return annoucement;
    }

    @DeleteMapping("/deleteAnnoucement/{annoucementId}")
    public String deleteAnnoucement(@PathVariable Long annoucementId) {
        return annoucementService.deleteAnnoucement(annoucementId);
    }

}
