package com.github.soonboylena.myflow.persistentneo4j.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Neo4jConfiguration {

    @Autowired
    private Neo4jProperties neo4jProperties;

//    @Bean
//    public Driver driver() {
//        return GraphDatabase.driver(neo4jProperties.getUri(), AuthTokens.basic(neo4jProperties.getUsername(), neo4jProperties.getPassword()));
//    }
}
