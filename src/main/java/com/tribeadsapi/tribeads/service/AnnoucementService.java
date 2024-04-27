package com.tribeadsapi.tribeads.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tribeadsapi.tribeads.models.Annoucement;
import com.tribeadsapi.tribeads.models.Comunity;
import com.tribeadsapi.tribeads.models.Country;
import com.tribeadsapi.tribeads.models.IsTargetRelation;
import com.tribeadsapi.tribeads.repository.AnnoucementRespository;
import com.tribeadsapi.tribeads.repository.CountryRepository;
import com.tribeadsapi.tribeads.request.CreateAnnoucementRequest;
import com.tribeadsapi.tribeads.request.GetAnnoucementByCreationDate;

@Service
public class AnnoucementService {

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    AnnoucementRespository annoucementRespository;

    public Annoucement createAnnoucement(CreateAnnoucementRequest annoucementRequest) {

        Country country = new Country();
        country.setCountryName(annoucementRequest.getCountry().getCountryName());
        country.setCapital(annoucementRequest.getCountry().getCapital());
        country.setPopulation(annoucementRequest.getCountry().getPopulation());
        countryRepository.save(country);

        List<IsTargetRelation> isTargetRelation = new ArrayList<>();
        if (annoucementRequest.getComunities() != null) {
            for (Comunity comunity : annoucementRequest.getComunities()) {
                Comunity newComunity = new Comunity();
                newComunity.setComunityName(comunity.getComunityName());
                newComunity.setTopic(comunity.getTopic());
                IsTargetRelation isTarget = new IsTargetRelation();
                isTarget.setComunity(comunity);
                isTarget.setMarks(isTarget.getMarks());
                isTargetRelation.add(isTarget);
            }
        }

        Annoucement newAnnoucement = new Annoucement();
        newAnnoucement.setTitle(annoucementRequest.getTitle());
        newAnnoucement.setRevenue(annoucementRequest.getRevenue());
        newAnnoucement.setSponsor(annoucementRequest.getSponsor());
        newAnnoucement.setDatePosted(annoucementRequest.getDatePosted());
        newAnnoucement.setDateExpired(annoucementRequest.getDateExpired());
        newAnnoucement.setDescription(annoucementRequest.getDescription());
        newAnnoucement.setCountry(country);
        newAnnoucement.setComunities(isTargetRelation);
        annoucementRespository.save(newAnnoucement);
        return newAnnoucement;
    }

    public Annoucement getAnnoucementByTitle(String title) {
        return annoucementRespository.findByTitle(title);
    }

    public String deleteAnnoucement(Long annoucementId) {
        annoucementRespository.deleteById(annoucementId);
        return "Annoucement deleted";
    }

    public List<Annoucement> getAllAnnoucements() {
        return annoucementRespository.findAll();
    }

    public List<Annoucement> getAnnoucementByDates(GetAnnoucementByCreationDate dates) {
        return annoucementRespository.findByDatePostedIn(dates.getDatesPosted());
    }

}
