package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class HealthCheckTest {

    @Test
    void testHealthEndpoint() {
        Response response = RestAssured.get("/health");

        assertThat(response.getStatusCode(), equalTo(200));

        assertThat(response.jsonPath().getString("status"), equalTo("OK"));
    }
}