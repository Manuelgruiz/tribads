package com.tribeadsapi.tribeads.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
        return languageService.createLanguage(languageRequest);
    }

    @GetMapping("/getLanguageByNameAndLevel/{languageName}/{level}")
    public Language getLenguageByNameAndLevel(@PathVariable String languageName, @PathVariable Integer level) {
        return languageService.getLanguageByNameAndLevel(languageName, level);
    }
}