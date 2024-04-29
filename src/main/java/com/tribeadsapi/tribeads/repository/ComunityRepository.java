package com.tribeadsapi.tribeads.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import com.tribeadsapi.tribeads.models.Comunity;

@Repository
public interface ComunityRepository extends Neo4jRepository<Comunity, Long> {

    Comunity findByComunityName(String name);

    @Query("MATCH (u:User)-[:BELONGS_TO]->(c:Comunity) " +
            "RETURN c AS ComunityNode, COUNT(u) AS NumberOfUsers " +
            "ORDER BY NumberOfUsers DESC " +
            "LIMIT 1")
    Comunity findComunityWithMostUsers();

}
