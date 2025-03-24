package com.project1.restapi;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import org.hamcrest.Matchers;

public class TC41_BASIC_AUTH_API {
	
	@Test
	public void basicAuthAPI() {
		
		given()
			.header("Accept","application/json")
			.auth().basic("user", "passwd")
			
		.when()
			.get("https://httpbin.org/basic-auth/user/passwd")
		
		.then()
			.log().body()
			.log().headers()
			.log().status()
			.time(Matchers.lessThan(4000L))
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.header("Content-Type", "application/json");
	}
}