package com.tribeadsapi.tribeads.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import com.tribeadsapi.tribeads.models.User;

@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {

    User findByEmail(String email);

    @Query("MATCH (u:User) " +
            "OPTIONAL MATCH (u)-[:FOLLOWS]->(follower:User) " +
            "OPTIONAL MATCH (u)-[:SPEAKS]->(language:Language) " +
            "WITH u, COUNT(DISTINCT follower) AS numFollowers, COUNT(DISTINCT language) AS numLanguages " +
            "RETURN u AS UserNode, numFollowers, numLanguages " +
            "ORDER BY numFollowers DESC, numLanguages DESC " +
            "LIMIT 1")
    User findMostInfluentialPolyglotUser();
}
