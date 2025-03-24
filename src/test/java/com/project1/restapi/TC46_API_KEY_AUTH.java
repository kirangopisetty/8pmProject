package com.project1.restapi;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import org.hamcrest.Matchers;

public class TC46_API_KEY_AUTH {

	@Test
	public void apiKeyAuth() {
		
		given()
			.header("Accept", "application/json")
			
		.when()
			.get("https://api.openweathermap.org/data/2.5/weather?q=Hyderabad&appid=ed9b8ed0edc090919795def6f872aef8")
		
		.then()
			.log().body()
			.log().status()
			.time(Matchers.lessThan(4000L))
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK");
	}
}