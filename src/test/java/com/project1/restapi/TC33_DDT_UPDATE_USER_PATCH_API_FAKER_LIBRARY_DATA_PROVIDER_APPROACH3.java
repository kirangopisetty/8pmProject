package com.project1.restapi;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static org.hamcrest.Matchers.*;
import org.json.JSONObject;

public class TC33_DDT_UPDATE_USER_PATCH_API_FAKER_LIBRARY_DATA_PROVIDER_APPROACH3 extends TC31_DDT_DATA_PROVIDER_APPROACH3{

	@Test(dataProvider="updateUserDDT")
	public void updateUserPATCHapiDDT(String name, String email, String status) {
		
		JSONObject reqBody = new JSONObject();
		reqBody.put("name", name);
		reqBody.put("email", email);
		reqBody.put("status", status);
			
			given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization","Bearer a1acf13036e08546446ecbcbeb75b11959fbfcc0795218a185cfc982f6982c29")
			
			.when()
				.body(reqBody.toString())
				.patch("https://gorest.co.in/public/v2/users/7763230")
			
			.then()
				.log().status()
				.log().body()
				.assertThat().body("gender", oneOf("male","female"))
				.assertThat().body("status", oneOf("active","inactive"))
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK")
				.time(lessThan(4000L))
				.header("Content-Type", "application/json; charset=utf-8");
		}
}