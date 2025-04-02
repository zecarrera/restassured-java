package org.example.config;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class RestAssuredConfig {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://mern-ecommerce-uote.onrender.com/api";
    }
}