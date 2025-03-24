package com.project1.restapi;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import org.hamcrest.Matchers;

public class TC43_BEARER_ACCESS_TOKEN_AUTH_API {
	
	@Test
	public void bearerAuthAPI() {
		
		given()
			.header("Accept", "application/json")
			.header("Authorization", "Bearer 12345")
		
		.when()
			.get("https://httpbin.org/bearer")
		
		.then()
			.statusCode(200)
			.time(Matchers.lessThan(3000L))
			.header("Content-Type", "application/json")
			.log().status()
			.log().body();		
	}
}