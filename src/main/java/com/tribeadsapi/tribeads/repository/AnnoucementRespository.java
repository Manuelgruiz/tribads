package com.tribeadsapi.tribeads.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.tribeadsapi.tribeads.models.Annoucement;
import java.util.List;
import java.util.Date;

@Repository
public interface AnnoucementRespository extends Neo4jRepository<Annoucement, Long> {
    Annoucement findByTitle(String title);

    List<Annoucement> findByDatePostedIn(List<Date> datePosted);

}