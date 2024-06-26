package com.tribeadsapi.tribeads;

import com.github.javafaker.Faker;
import com.tribeadsapi.tribeads.controller.AnnoucementController;
import com.tribeadsapi.tribeads.controller.ComunityController;
import com.tribeadsapi.tribeads.controller.CountryController;
import com.tribeadsapi.tribeads.controller.LanguageController;
import com.tribeadsapi.tribeads.controller.UserController;
import com.tribeadsapi.tribeads.controller.UserDTO;
import com.tribeadsapi.tribeads.models.Annoucement;
import com.tribeadsapi.tribeads.models.Comunity;
import com.tribeadsapi.tribeads.models.Country;
import com.tribeadsapi.tribeads.models.Language;
import com.tribeadsapi.tribeads.models.User;
import com.tribeadsapi.tribeads.request.CreateAnnoucementRequest;
import com.tribeadsapi.tribeads.request.CreateComunityRequest;
import com.tribeadsapi.tribeads.request.CreateCountryRequest;
import com.tribeadsapi.tribeads.request.CreateLanguageRequest;
import com.tribeadsapi.tribeads.request.CreateUserFollow;
import com.tribeadsapi.tribeads.request.CreateUserRequest;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class populate {

    @Autowired
    private UserController userController;

    @Autowired
    private LanguageController languageController;

    @Autowired
    private CountryController countryController;

    @Autowired
    private ComunityController comunityController;

    @Autowired
    private AnnoucementController annoucementController;

    private Faker faker = new Faker();

    @PostConstruct
    @Transactional
    public void generateData() {

        // Elegir cantidad de datos a generar
        Integer usuarios = 100;
        Integer idiomas = 10;
        Integer paises = 10;
        Integer comunidades = 10;
        Integer anuncios = 100;

        // Generar datos
        // createData(usuarios, idiomas, paises, comunidades, anuncios);
    }

    public void createData(Integer usuarios, Integer idiomas, Integer paises, Integer comunidades, Integer anuncios) {
        createUser(usuarios);
        createLanguages(idiomas);
        createCountry(paises);
        createCommunity(comunidades);
        createAnnoucement(anuncios);
        createFollows();
        createSpeaks();
        createBelongsTo();
        createIsMemberOf();
        createAnnoucementInCountry();
        createAnnoucementInCommunity();
    }

    public void createUser(Integer n) {
        List<User> users = new ArrayList<>();
        // Crear Users
        for (int i = 0; i < n; i++) {
            CreateUserRequest user = new CreateUserRequest();
            user.setName(faker.name().fullName());
            user.setGender(faker.demographic().sex());
            user.setYear(faker.number().numberBetween(1950, 2022)); // Ajusta los rangos según tus necesidades
            user.setBirthDate(faker.date().birthday());
            user.setEmail(faker.internet().emailAddress());
            user.setPassword(faker.internet().password());
            User usercreado = userController.createuser(user);
            users.add(usercreado);
        }
    }

    public void createLanguages(Integer n) {
        List<Language> languages = new ArrayList<>();
        // Crear Languages
        List<String> languageNames = Arrays.asList("Spanish", "English", "French", "German", "Italian", "Portuguese",
                "Russian", "Chinese", "Japanese", "Korean");

        for (int i = 0; i < n; i++) {
            CreateLanguageRequest language = new CreateLanguageRequest();
            language.setLanguageName(languageNames.get(i));
            language.setLevel(faker.number().numberBetween(1, 10));
            Language languagecreado = languageController.createLanguage(language);
            languages.add(languagecreado);
        }
    }

    public void createCountry(Integer n) {
        List<Country> countries = new ArrayList<>();
        // Crear Countries
        for (int i = 0; i < n; i++) {
            CreateCountryRequest country = new CreateCountryRequest();
            country.setCountryName(faker.address().country());
            country.setCapital(faker.address().city());
            country.setPopulation(faker.number().numberBetween(100000, 100000000));
            Country countrycreado = countryController.createCountry(country);
            countries.add(countrycreado);
        }
    }

    public void createCommunity(Integer n) {
        List<Comunity> comunities = new ArrayList<>();
        // Crear Comunities
        for (int i = 0; i < n; i++) {
            CreateComunityRequest comunity = new CreateComunityRequest();
            comunity.setComunityName(faker.team().name());
            comunity.setTopic(faker.lorem().sentence());
            Comunity comunitycreado = comunityController.createComunity(comunity);
            comunities.add(comunitycreado);
        }
    }

    public void createAnnoucement(Integer n) {
        List<Annoucement> annoucements = new ArrayList<>();
        // Crear Annoucements
        for (int i = 0; i < n; i++) {
            CreateAnnoucementRequest annoucement = new CreateAnnoucementRequest();
            annoucement.setTitle(faker.lorem().sentence());
            annoucement.setRevenue(faker.number().numberBetween(1000L, 100000L));
            annoucement.setSponsor(faker.company().name());
            annoucement.setDatePosted(faker.date().birthday());
            annoucement.setDateExpired(faker.date().birthday());
            annoucement.setDescription(faker.lorem().paragraph());
            Annoucement annoucementcreado = annoucementController.createAnnoucement(annoucement);
            annoucements.add(annoucementcreado);
        }
    }

    public void createFollows() {
        List<UserDTO> users = userController.getAllUsers();
        for (UserDTO user : users) {
            int n = faker.number().numberBetween(0, 5);
            for (int i = 0; i < n; i++) {
                UserDTO userToFollow = users.get(faker.number().numberBetween(0, users.size()));
                if (!userToFollow.getUserId().equals(user.getUserId())) {
                    CreateUserFollow createUserFollow = new CreateUserFollow();
                    createUserFollow.setUserId1(user.getUserId());
                    createUserFollow.setUserId2(userToFollow.getUserId());
                    userController.createFollow(createUserFollow);
                }
            }

        }
    }

    public void createSpeaks() {
        List<UserDTO> users = userController.getAllUsers();
        List<Language> languages = languageController.getAllLanguages();
        for (UserDTO user : users) {
            int n = faker.number().numberBetween(1, 3);
            for (int i = 0; i < n; i++) {
                Language language = languages.get(faker.number().numberBetween(0, languages.size()));
                userController.connectLenguage(user.getUserId(), language.getLanguageId());
            }
        }
    }

    public void createBelongsTo() {
        List<UserDTO> users = userController.getAllUsers();
        List<Country> countries = countryController.getAllCountries();
        for (UserDTO user : users) {
            Country country = countries.get(faker.number().numberBetween(0, countries.size()));
            userController.connectCountry(user.getUserId(), country.getCountryId());
        }
    }

    public void createIsMemberOf() {
        List<UserDTO> users = userController.getAllUsers();
        List<Comunity> comunities = comunityController.getAllComunities();
        for (UserDTO user : users) {
            int n = faker.number().numberBetween(1, 3);
            for (int i = 0; i < n; i++) {
                Comunity comunity = comunities.get(faker.number().numberBetween(0, comunities.size()));
                userController.connectCommunity(user.getUserId(), comunity.getComunityId());
            }
        }
    }

    public void createAnnoucementInCountry() {
        List<Annoucement> annoucements = annoucementController.getAllAnnoucements();
        List<Country> countries = countryController.getAllCountries();
        for (Annoucement annoucement : annoucements) {
            Country country = countries.get(faker.number().numberBetween(0, countries.size()));
            annoucementController.connenctCountryToAnnoucement(annoucement.getAnnoucementId(), country.getCountryId());
        }
    }

    public void createAnnoucementInCommunity() {
        List<Annoucement> annoucements = annoucementController.getAllAnnoucements();
        List<Comunity> comunities = comunityController.getAllComunities();
        for (Annoucement annoucement : annoucements) {
            int n = faker.number().numberBetween(1, 3);
            for (int i = 0; i < n; i++) {
                Comunity comunity = comunities.get(faker.number().numberBetween(0, comunities.size()));
                annoucementController.connectCommunityToAnnoucement(annoucement.getAnnoucementId(),
                        comunity.getComunityId());
            }
        }
    }
}
