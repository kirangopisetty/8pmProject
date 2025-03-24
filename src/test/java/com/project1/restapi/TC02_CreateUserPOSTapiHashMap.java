package com.project1.restapi;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import org.hamcrest.Matchers;
import java.util.HashMap;

public class TC02_CreateUserPOSTapiHashMap {
	
	@Test
	public void createUserPOSTapi() {
	
	HashMap<String, String> requestBody = new HashMap<String, String>();
	requestBody.put("name", "Kiran");
	requestBody.put("gender","male");
	requestBody.put("email","kiran@2b.com");
	requestBody.put("status","active");
	
		given()
			.header("Accept","application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", "Bearer a1acf13036e08546446ecbcbeb75b11959fbfcc0795218a185cfc982f6982c29")
		
		.when()
			.body(requestBody)
			.post("https://gorest.co.in/public/v2/users")
		
		.then()
			.log().status()
			.log().body()
			.statusCode(201)
			.statusLine("HTTP/1.1 201 Created")
			.assertThat().body("gender", oneOf("male","female"))
			.assertThat().body("status", oneOf("active","inactive"))
		//	.body("gender", hasItems("male","female"))
			.time(Matchers.lessThan(4000L))
			.body("name", equalTo("Kiran"))
			.body("gender", equalTo("male"))
			.body("status", equalTo("active"))
			.header("Content-Type", "application/json; charset=utf-8");	
	}
}