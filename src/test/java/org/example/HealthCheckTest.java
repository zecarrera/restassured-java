package org.example;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.example.config.RestAssuredConfig;

class HealthCheckTest extends RestAssuredConfig {

    /*
     * This test exemplifies how to log the request URI and check on a response body property
     */
    @Test
    void get_health_returns_200_and_status_OK() {
        given()
            .log().uri()
            .get("/health")
        .then()
            .statusCode(200)
            .body("status", equalTo("OK"));
    }
}
