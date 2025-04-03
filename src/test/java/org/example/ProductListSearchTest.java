package org.example;

import org.example.config.RestAssuredConfig;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ProductListSearchTest extends RestAssuredConfig {

    /*
     * This test exemplifies how to use path parameters
     */
    @ParameterizedTest(name = "SearchInput: {0}")
    @ValueSource(strings = {"shoes", "toys", "shirt"})
    void get_product_list_search_returns_200_and_search_results(String searchInput) {
        System.out.println("Running test with searchInput: " + searchInput);

        given()
            .pathParam("name", searchInput)
        .when()
            .get("/product/list/search/{name}")
        .then()
            .assertThat()
            .statusCode(200)
            .body(matchesJsonSchemaInClasspath("schemas/product-list-search-schema.json"));
    }
}
