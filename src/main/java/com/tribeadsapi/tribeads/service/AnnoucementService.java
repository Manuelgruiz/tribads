package com.tribeadsapi.tribeads.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tribeadsapi.tribeads.models.Annoucement;
import com.tribeadsapi.tribeads.models.Country;
import com.tribeadsapi.tribeads.repository.AnnoucementRespository;
import com.tribeadsapi.tribeads.repository.CountryRepository;
import com.tribeadsapi.tribeads.request.CreateAnnoucementRequest;

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

        Annoucement newAnnoucement = new Annoucement();
        newAnnoucement.setTitle(annoucementRequest.getTitle());
        newAnnoucement.setRevenue(annoucementRequest.getRevenue());
        newAnnoucement.setSponsor(annoucementRequest.getSponsor());
        newAnnoucement.setDatePosted(annoucementRequest.getDatePosted());
        newAnnoucement.setDateExpired(annoucementRequest.getDateExpired());
        newAnnoucement.setDescription(annoucementRequest.getDescription());
        newAnnoucement.setCountry(country);
        annoucementRespository.save(newAnnoucement);
        return newAnnoucement;

    }

}
