package com.qa.api.testcases;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDeleteExample {	
	@Test
	public void test_put() {
		baseURI = "https://reqres.in/api";
		
		JSONObject request = new JSONObject();
		request.put("name", "morpheus");
		request.put("job", "zion resident");
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/api/users/2").
		then().
			statusCode(200).log().all();
	}
	
	@Test
	public void test_patch() {
		baseURI = "https://reqres.in/api";
		
		JSONObject request = new JSONObject();
		request.put("name", "morpheus");
		request.put("job", "zion resident");
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/api/users/2").
		then().
			statusCode(200).log().all();		
	}
	
	@Test
	public void test_delete() {		
		baseURI = "https://reqres.in/api";
						
		when().			
			delete("/api/users/2").
		then().
			statusCode(204).log().all();
		
	}
}
