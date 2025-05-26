package com.qa.api.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

public class ExampleTest {

    @BeforeClass
    public void setup() {
        baseURI = "https://reqres.in/api";
    }

    @Test
    public void test_1() {
        Response response = given()
                .header("x-api-key", "reqres-free-v1")
            .when()
                .get("/users?page=2");

        System.out.println(response.statusCode());
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));

        int status_code = response.getStatusCode();
        Assert.assertEquals(status_code, 200);
    }

    @Test
    public void test_2() {
        given()
            .header("x-api-key", "reqres-free-v1")
        .when()
            .get("/users?page=2")
        .then()
            .statusCode(200)
            .body("data[1].id", equalTo(8))
            .log().all();
    }
}
