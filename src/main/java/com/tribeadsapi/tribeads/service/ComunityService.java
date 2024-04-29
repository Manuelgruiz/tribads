package com.tribeadsapi.tribeads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tribeadsapi.tribeads.models.Comunity;
import com.tribeadsapi.tribeads.repository.ComunityRepository;
import com.tribeadsapi.tribeads.request.CreateComunityRequest;

@Service
public class ComunityService {
    @Autowired
    ComunityRepository comunityRepository;

    public Comunity getComunityById(Long id) {
        return comunityRepository.findById(id).get();
    }

    public Comunity createComunity(CreateComunityRequest comunity) {
        Comunity newComunity = new Comunity();
        newComunity.setComunityName(comunity.getComunityName());
        newComunity.setTopic(comunity.getTopic());
        comunityRepository.save(newComunity);
        return newComunity;
    }

    public Comunity getComunityByName(String name) {
        return comunityRepository.findByComunityName(name);
    }

    public List<Comunity> getAllComunities() {
        return comunityRepository.findAll();
    }

    public String deleteComunity(Long comunityId) {
        comunityRepository.deleteById(comunityId);
        return "Comunity deleted";
    }

}
