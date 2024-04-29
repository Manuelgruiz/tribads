package com.tribeadsapi.tribeads.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;
import com.tribeadsapi.tribeads.models.Country;

@Repository
public interface CountryRepository extends Neo4jRepository<Country, Long> {
    Country findByCountryName(String name);

    @Query("MATCH (u:User)-[:LIVED_IN]->(c:Country) " +
            "RETURN c AS CountryNode, COUNT(u) AS NumberOfUsers " +
            "ORDER BY NumberOfUsers DESC " +
            "LIMIT 1")
    Country findCountryWithMostUsers();

}
