package org.example.config;

import io.restassured.RestAssured;

public class RestAssuredConfig {

    static {
        String environment = System.getenv("ENVIRONMENT");
        RestAssured.baseURI = "local".equalsIgnoreCase(environment) 
            ? "http://localhost:9011/api" 
            : "https://mern-ecommerce-uote.onrender.com/api";
    }
}