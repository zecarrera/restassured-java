package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.config.RestAssuredConfig;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;

class CategoryListTest extends RestAssuredConfig {

    @Test
    void testCategoryListEndpoint() {
        Response response = RestAssured.get("/category/list");

        assertThat(response.getStatusCode(), equalTo(200));

        List<Map<String, Object>> categoriesList = response.jsonPath().getList("categories");

        assertThat(categoriesList, notNullValue());
        assertThat(categoriesList, everyItem(allOf(
            hasEntry(equalTo("_id"), notNullValue()),
            hasEntry(equalTo("name"), notNullValue()),
            hasEntry(equalTo("description"), notNullValue()),
            hasEntry(equalTo("products"), notNullValue()),
            hasEntry(equalTo("isActive"), notNullValue())
        )));

        assertThat(categoriesList.size(), greaterThan(0));
    }
}