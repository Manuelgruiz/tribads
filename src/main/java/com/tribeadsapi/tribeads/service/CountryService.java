package com.tribeadsapi.tribeads.service;

import java.util.List;

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
        if (countryRepository.findByCountryName(country.getCountryName()) != null) {
            return null;
        }
        Country newCountry = new Country();
        newCountry.setCountryName(country.getCountryName());
        newCountry.setCapital(country.getCapital());
        newCountry.setPopulation(country.getPopulation());
        countryRepository.save(newCountry);
        return newCountry;
    }

    public Country getCountryById(Long id) {
        return countryRepository.findById(id).get();
    }

    public Country getCountryByName(String name) {
        return countryRepository.findByCountryName(name);
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public String deleteCountry(Long countryId) {
        countryRepository.deleteById(countryId);
        return "Country deleted";
    }

}
