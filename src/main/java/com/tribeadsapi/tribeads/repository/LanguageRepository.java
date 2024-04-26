package com.tribeadsapi.tribeads.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.tribeadsapi.tribeads.models.Language;

@Repository
public interface LanguageRepository extends Neo4jRepository<Language, Long> {

}
