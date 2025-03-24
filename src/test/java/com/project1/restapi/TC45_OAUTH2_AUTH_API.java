package com.project1.restapi;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import org.hamcrest.Matchers;

public class TC45_OAUTH2_AUTH_API {
	
	@Test
	public void oAuth2API() {
		
		given()
			.header("Accept", "application/json")
			.auth().oauth2("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")
		
		.when()
			.get("https://api.github.com/user/repos")
		
		.then()
			.log().body()
			.log().headers()
			.log().status()
			.time(Matchers.lessThan(4000L))
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.header("Content-Type", "application/json; charset=utf-8");
	}
}