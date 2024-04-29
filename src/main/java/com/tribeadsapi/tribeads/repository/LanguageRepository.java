package com.tribeadsapi.tribeads.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import com.tribeadsapi.tribeads.models.Language;

@Repository
public interface LanguageRepository extends Neo4jRepository<Language, Long> {
    Language findByLanguageNameAndLevel(String languageName, Integer level);

    @Query("MATCH (u:User)-[:SPEAKS]->(l:Language) " +
            "RETURN l AS LanguageNode, COUNT(u) AS NumberOfUsers " +
            "ORDER BY NumberOfUsers DESC " +
            "LIMIT 1")
    Language findMostSpokenLanguage();
}
