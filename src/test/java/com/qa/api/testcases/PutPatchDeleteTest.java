package com.qa.api.testcases;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDeleteTest {	
	
	@BeforeClass
    public void setup() {
        baseURI = "https://reqres.in/api";
    }
	
	@Test
	public void test_put() {		
		JSONObject request = new JSONObject();
		request.put("name", "morpheus");
		request.put("job", "zion resident");
		
		given()
			.header("x-api-key", "reqres-free-v1")
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.put("/api/users/2")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	public void test_patch() {	
		
		JSONObject request = new JSONObject();
		request.put("name", "morpheus");
		request.put("job", "zion resident");
		
		given()
			.header("x-api-key", "reqres-free-v1")
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.patch("/api/users/2")
		.then()
			.statusCode(200)
			.log().all();		
	}
	
	@Test
	public void test_delete() {	
		given()
			.header("x-api-key", "reqres-free-v1")
		.when()			
			.delete("/api/users/2")
		.then()
			.statusCode(204).log().all();		
	}
}
