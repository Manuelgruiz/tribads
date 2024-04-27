package com.tribeadsapi.tribeads.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tribeadsapi.tribeads.models.Country;
import com.tribeadsapi.tribeads.request.CreateCountryRequest;
import com.tribeadsapi.tribeads.service.CountryService;

@RestController
@RequestMapping("/api/country/")
public class CountryController {

    @Autowired
    CountryService countryService;

    @PostMapping("/create")
    public Country createuser(@RequestBody CreateCountryRequest countryRequest) {
        return countryService.createCountry(countryRequest);
    }

    @GetMapping("/getByCountryName/{name}")
    public Country getCountryByName(@PathVariable String name) {
        return countryService.getCountryByName(name);
    }

    @DeleteMapping("/delete/{countryId}")
    public String deleteCountry(@PathVariable Long countryId) {
        return countryService.deleteCountry(countryId);
    }

}
