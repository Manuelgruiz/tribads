package com.tribeadsapi.tribeads.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tribeadsapi.tribeads.models.Country;
import com.tribeadsapi.tribeads.repository.CountryRepository;
import com.tribeadsapi.tribeads.request.CreateCountryRequest;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;

    public Country createCountry(CreateCountryRequest country) {
        Country newCountry = new Country();
        newCountry.setCountryName(country.getCountryName());
        newCountry.setCapital(country.getCapital());
        newCountry.setPopulation(country.getPopulation());
        countryRepository.save(newCountry);
        return newCountry;
    }

    public Country getCountryByName(String name) {
        return countryRepository.findByCountryName(name);
    }

    public String deleteCountry(Long countryId) {
        countryRepository.deleteById(countryId);
        return "Country deleted";
    }

}
