package com.tribeadsapi.tribeads.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tribeadsapi.tribeads.models.Comunity;
import com.tribeadsapi.tribeads.models.Country;
import com.tribeadsapi.tribeads.models.IsBelongsToRelation;
import com.tribeadsapi.tribeads.models.IsSpeakingRelation;
import com.tribeadsapi.tribeads.models.Language;
import com.tribeadsapi.tribeads.models.User;
import com.tribeadsapi.tribeads.repository.ComunityRepository;
import com.tribeadsapi.tribeads.repository.CountryRepository;
import com.tribeadsapi.tribeads.repository.LanguageRepository;
import com.tribeadsapi.tribeads.repository.UserRepository;
import com.tribeadsapi.tribeads.request.CreateComunityRequest;
import com.tribeadsapi.tribeads.request.CreateLanguageRequest;
import com.tribeadsapi.tribeads.request.CreateUserRequest;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    LanguageRepository languageRepository;

    @Autowired
    ComunityRepository comunityRepository;

    public User createUser(CreateUserRequest user) {
        Country country = new Country();
        country.setCountryName(user.getCountry().getCountryName());
        country.setCapital(user.getCountry().getCapital());
        country.setPopulation(user.getCountry().getPopulation());
        countryRepository.save(country);

        List<IsSpeakingRelation> isSpeakingRelation = new ArrayList<>();
        if (user.getLanguages() != null) {
            for (CreateLanguageRequest createLanguageRequest : user.getLanguages()) {
                Language newLanguage = new Language();
                newLanguage.setLanguageName(createLanguageRequest.getLanguageName());
                newLanguage.setLevel(createLanguageRequest.getLevel());
                languageRepository.save(newLanguage);
                IsSpeakingRelation isSpeaking = new IsSpeakingRelation();
                isSpeaking.setLanguage(newLanguage);
                isSpeakingRelation.add(isSpeaking);
            }
        }
        List<IsBelongsToRelation> isBelongsToRelation = new ArrayList<>();
        if (user.getComunities() != null) {
            for (CreateComunityRequest createComunityRequest : user.getComunities()) {
                Comunity newComunity = new Comunity();
                newComunity.setComunityName(createComunityRequest.getComunityName());
                newComunity.setTopic(createComunityRequest.getTopic());
                comunityRepository.save(newComunity);
                IsBelongsToRelation isBelongsTo = new IsBelongsToRelation();
                isBelongsTo.setComunity(newComunity);
                isBelongsTo.setMarks(isBelongsTo.getMarks());
                isBelongsToRelation.add(isBelongsTo);
            }
        }

        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setGender(user.getGender());
        newUser.setYear(user.getYear());
        newUser.setBirthDate(user.getBirthDate());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setCountry(country);
        newUser.setLanguages(isSpeakingRelation);
        newUser.setComunities(isBelongsToRelation);
        userRepository.save(newUser);

        return newUser;

    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
