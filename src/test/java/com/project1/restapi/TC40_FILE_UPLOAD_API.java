package com.project1.restapi;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import java.io.File;

public class TC40_FILE_UPLOAD_API {
	
	@Test
	public void fileUploadAPI() {
		
		File fileToUpload = new File("C:\\Users\\Kiran\\Downloads\\REST ASSURED-API AUTOMATION TESTING\\downloadGetAPIresponse.json");
		
		given()
			.multiPart("file", fileToUpload, "multipart/form-data")
			
		.when()
			.post("https://the-internet.herokuapp.com/upload")
		
		.then()
			.log().body()
			.statusCode(200)
			.log().status();
	}
}