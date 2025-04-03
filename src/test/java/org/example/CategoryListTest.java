package org.example;

import org.example.config.RestAssuredConfig;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

class CategoryListTest extends RestAssuredConfig {

    /*
     * This test exemplifies how to check the responses matches the schema definition
     */
    @Test
    void get_category_list_returns_200_and_list_of_categories()  {
        given()
            .get("/category/list")
        .then()
            .assertThat()
            .statusCode(200)
            .body(matchesJsonSchemaInClasspath("schemas/category-list-schema.json"))
            .body("categories.size()", greaterThan(0))
            .body("categories.findAll { it.isActive == true }.size()", greaterThan(0));
    }
}
