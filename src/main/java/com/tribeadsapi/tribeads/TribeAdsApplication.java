package com.tribeadsapi.tribeads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EntityScan("com.tribeadsapi.tribeads.models")
@EnableNeo4jRepositories("com.tribeadsapi.tribeads.repository")
public class TribeAdsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TribeAdsApplication.class, args);
	}

}
