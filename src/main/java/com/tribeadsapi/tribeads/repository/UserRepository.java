package com.tribeadsapi.tribeads.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tribeadsapi.tribeads.controller.FollowerDTO;
import com.tribeadsapi.tribeads.models.User;

@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {

    User findByEmail(String email);

    @Query("MATCH (u:User) " +
            "OPTIONAL MATCH (follower:User)-[:FOLLOWS]->(u) " +
            "OPTIONAL MATCH (u)-[:SPEAKS]->(language:Language) " +
            "WITH u, COUNT(DISTINCT follower) AS numFollowers, COUNT(DISTINCT language) AS numLanguages " +
            "RETURN u AS UserNode, numFollowers, numLanguages " +
            "ORDER BY numFollowers DESC, numLanguages DESC " +
            "LIMIT 1")
    User findMostInfluentialPolyglotUser();

    @Query("MATCH (follower:User)-[:FOLLOWS]->(u:User) " +
            "WHERE u.email = $email " +
            "RETURN follower.name AS name, follower.email AS email")
    List<FollowerDTO> findFollowersByEmail(@Param("email") String email);

}
