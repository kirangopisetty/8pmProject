package com.project1.restapi;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import org.hamcrest.Matchers;
import org.json.JSONObject;

public class TC03_CreateUserPOSTapiJsonObject {
	
	@Test
	public void createUserPOSTapiJsonObject() {
	
	JSONObject requestBody = new JSONObject();
	requestBody.put("name", "Isha");
	requestBody.put("gender", "female");
	requestBody.put("email", "isha@7pm.com");
	requestBody.put("status", "active");
		
		given()
			.header("Accept","application/json")
			.header("Content-Type","application/json")
			.header("Authorization","Bearer a1acf13036e08546446ecbcbeb75b11959fbfcc0795218a185cfc982f6982c29")
		
		.when()
			.body(requestBody.toString())
			.post("https://gorest.co.in/public/v2/users")
		
		.then()
			.log().status()
			.log().body()
			.log().headers()
			.assertThat().body("gender", oneOf("male","female"))
			.assertThat().body("status", oneOf("active","inactive"))
			.statusCode(201)
			.statusLine("HTTP/1.1 201 Created")
			.time(lessThan(4000L))
			.header("Content-Type", "application/json; charset=utf-8")
			.body("name", equalTo("Isha"))
			.body("gender", equalTo("female"))
			.body("status", equalTo("active"));
	}
}