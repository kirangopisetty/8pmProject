package com.project1.restapi;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import org.hamcrest.Matchers;

public class TC44_OAUTH1_AUTH_API {
	
	@Test
	public void oAuth1API() {
		
		given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.auth().oauth("consumerKey", "consumerSecret", "accessToken", "secretToken")
					
		.when()
			.get("type your API oAuth1 URL")
		
		.then()
			.statusCode(200)
			.time(Matchers.lessThan(3000L))
			.header("Content-Type", "application/json")
			.log().status()
			.log().body();	
	}
}