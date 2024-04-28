package com.tribeadsapi.tribeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tribeadsapi.tribeads.models.Annoucement;
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

    public Annoucement getAnnoucementById(Long id) {
        return annoucementRespository.findById(id).get();
    }

    public Annoucement createAnnoucement(CreateAnnoucementRequest annoucementRequest) {

        Annoucement newAnnoucement = new Annoucement();
        newAnnoucement.setTitle(annoucementRequest.getTitle());
        newAnnoucement.setRevenue(annoucementRequest.getRevenue());
        newAnnoucement.setSponsor(annoucementRequest.getSponsor());
        newAnnoucement.setDatePosted(annoucementRequest.getDatePosted());
        newAnnoucement.setDateExpired(annoucementRequest.getDateExpired());
        newAnnoucement.setDescription(annoucementRequest.getDescription());
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

    public void save(Annoucement annoucement) {
        annoucementRespository.save(annoucement);
    }

}
