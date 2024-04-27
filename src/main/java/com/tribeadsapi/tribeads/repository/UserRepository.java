package com.tribeadsapi.tribeads.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import com.tribeadsapi.tribeads.models.User;

@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {
    User findByEmail(String email);
}
