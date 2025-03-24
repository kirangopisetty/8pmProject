package com.project1.restapi;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class TC08_DeleteUserAPI {
	
	@Test
	public void deleteUserAPI() {
		
		given()
			.header("Accept","application/json")
			.header("Content-Type","application/json")
			.header("Authorization","Bearer a1acf13036e08546446ecbcbeb75b11959fbfcc0795218a185cfc982f6982c29")
		
		.when()
			.delete("https://gorest.co.in/public/v2/users/7744884")
		
		.then()
			.log().status()
			.statusCode(204)
			.statusLine("HTTP/1.1 204 No Content")
			.body(isEmptyOrNullString());	
	}
}