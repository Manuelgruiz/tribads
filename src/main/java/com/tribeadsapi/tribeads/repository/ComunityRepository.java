package com.tribeadsapi.tribeads.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.tribeadsapi.tribeads.models.Comunity;

@Repository
public interface ComunityRepository extends Neo4jRepository<Comunity, Long> {

    Comunity findByComunityName(String name);

}
