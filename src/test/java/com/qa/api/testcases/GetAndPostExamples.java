package com.qa.api.testcases;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAndPostExamples {	

	@Test	
	public void test_get() {
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[4].first_name", equalTo("George")).
			body("data.first_name", hasItems("Lindsay", "Tobias"))
			.log().all();
	}
	
	@Test	
	public void test_post() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "Vishva");
//		map.put("job", "SDET");
//		System.out.println(map);
		
//		JSONObject request = new JSONObject(map);
//		System.out.println(request);
		
		JSONObject request = new JSONObject();
		request.put("name", "Vishva");
		request.put("job", "SDET");
		String requestBody = "{\n" +
	            "  \"name\": \"Vishva\",\n" +
	            "  \"job\": \"SDET\"\n" +
	            "}";
		System.out.println(request.toJSONString());
		baseURI = "https://reqres.in/api";
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
//			body(request.toJSONString()).
			body(requestBody).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
	}
}
