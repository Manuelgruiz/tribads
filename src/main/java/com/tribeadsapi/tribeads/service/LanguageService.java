package com.tribeadsapi.tribeads.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tribeadsapi.tribeads.models.Language;
import com.tribeadsapi.tribeads.repository.LanguageRepository;
import com.tribeadsapi.tribeads.request.CreateLanguageRequest;

@Service
public class LanguageService {
    @Autowired
    LanguageRepository languageRepository;

    public Language createLanguage(CreateLanguageRequest language) {
        Language newLanguage = new Language();
        newLanguage.setLanguageName(language.getLanguageName());
        newLanguage.setLevel(language.getLevel());
        languageRepository.save(newLanguage);
        return newLanguage;
    }

    public Language getLanguageByNameAndLevel(String languageName, Integer level) {
        return languageRepository.findByLanguageNameAndLevel(languageName, level);

    }

    public String deleteService(Long serviceId) {
        languageRepository.deleteById(serviceId);
        return "Service deleted";
    }

}
