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

import com.tribeadsapi.tribeads.models.Language;
import com.tribeadsapi.tribeads.request.CreateLanguageRequest;
import com.tribeadsapi.tribeads.service.LanguageService;

@RestController
@RequestMapping("/api/language/")
public class LanguageController {

    @Autowired
    LanguageService languageService;

    @PostMapping("/create")
    public Language createLanguage(@RequestBody CreateLanguageRequest languageRequest) {
        if (languageService.getLanguageByNameAndLevel(languageRequest.getLanguageName(),
                languageRequest.getLevel()) != null) {
            return null;
        }
        return languageService.createLanguage(languageRequest);
    }

    @GetMapping("/getLanguageByNameAndLevel/{languageName}/{level}")
    public Language getLenguageByNameAndLevel(@PathVariable String languageName, @PathVariable Integer level) {
        return languageService.getLanguageByNameAndLevel(languageName, level);
    }

    @GetMapping("/getAllLanguages")
    public List<Language> getAllLanguages() {
        return languageService.getAllLanguages();
    }

    @DeleteMapping("/deleteService/{serviceId}")
    public String deleteService(@PathVariable Long serviceId) {
        return languageService.deleteService(serviceId);
    }

    @GetMapping("/getLanguageWithMostUsers")
    public Language getLanguageWithMostUsers() {
        return languageService.getLanguageWithMostUsers();
    }
}