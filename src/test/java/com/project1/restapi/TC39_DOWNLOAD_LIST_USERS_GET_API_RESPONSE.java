package com.project1.restapi;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TC39_DOWNLOAD_LIST_USERS_GET_API_RESPONSE {

	@Test
	public void downloadGetAPIresponse() throws IOException {
		
	Response response = given()	// api request section
			.header("Accept", "application/json")
			.header("Content-Type","application/json")
			.header("Authorization","Bearer a1acf13036e08546446ecbcbeb75b11959fbfcc0795218a185cfc982f6982c29")
		
		.when()		// api request section
			.get("https://gorest.co.in/public/v2/users")
			.thenReturn();
	
		byte[] bytes = response.getBody().asByteArray();	// capture the byte[] response
		File file = new File("C:\\Users\\Kiran\\Downloads\\REST ASSURED-API AUTOMATION TESTING\\downloadGetAPIresponse.json");
		Files.write(file.toPath(), bytes);	// write byte[] response into the specified file
	}
}