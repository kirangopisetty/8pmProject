package com.project1.restapi;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.hamcrest.Matchers;

@Epic("Epic:SOAP APIs Automation Testing")
public class TC48_SOAP_APIs {
	
	@Feature("ADDITION-SOAP API")
	@Description("This is a SOAP API that uses POST http method")
	@Story("As a user, I can add 2 integers to get addResult")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 1)
	public void addSOAPapi() throws IOException {
		
	File file = new File("./src/test/resources/addSOAPapiRequestBody.xml");	// establishing connection to the file location
	FileInputStream fileInputStream = new FileInputStream(file);	// reading the file content
	String addRequestBody = IOUtils.toString(fileInputStream, "UTF-8");
	
		given()
			.header("Content-Type", "text/xml; charset=utf-8")
			.header("SOAPAction", "http://tempuri.org/Add")
		
		.when()
			.body(addRequestBody)
			.post("http://www.dneonline.com/calculator.asmx")
		
		.then()
			.statusCode(200)
			.log().all()
			.header("Content-Type", "text/xml; charset=utf-8")
			.time(Matchers.lessThan(3000L));
			System.out.println("Addition SOAP API test execution is Completed");
	}
	
	@Feature("SUBTRACTION-SOAP API")
	@Description("This is a SOAP API that uses POST http method")
	@Story("As a user, I can subtract 2 integers to get subtractResult")
	@Severity(SeverityLevel.CRITICAL)
	@Test (priority = 2)
	public void subtractSOAPapi() throws IOException {
		
		File file = new File("./src/test/resources/subtractSOAPapiRequestBody.xml");	// establishing connection to the file location
		FileInputStream fileInputStream = new FileInputStream(file);	// reading the file content
		String subtractRequestBody = IOUtils.toString(fileInputStream, "UTF-8");
		
			given()
				.header("Content-Type", "text/xml; charset=utf-8")
				.header("SOAPAction", "http://tempuri.org/Subtract")
			
			.when()
				.body(subtractRequestBody)
				.post("http://www.dneonline.com/calculator.asmx")
			
			.then()
				.statusCode(200)
				.log().all()
				.header("Content-Type", "text/xml; charset=utf-8")
				.time(Matchers.lessThan(3000L));
				System.out.println("Subtraction SOAP API test execution is Completed");
	}
	
	@Feature("MULTIPLY-SOAP API")
	@Description("This is a SOAP API that uses POST http method")
	@Story("As a user, I can multiply 2 integers to get multiplyResult")
	@Severity(SeverityLevel.CRITICAL)
	@Test (priority = 3)
	public void multiplySOAPapi() throws IOException {
		
		File file = new File("./src/test/resources/multiplySOAPapiRequestBody.xml");	// establishing connection to the file location
		FileInputStream fileInputStream = new FileInputStream(file);	// reading the file content
		String multiplyRequestBody = IOUtils.toString(fileInputStream, "UTF-8");
		
			given()
				.header("Content-Type", "text/xml; charset=utf-8")
				.header("SOAPAction", "http://tempuri.org/Multiply")
			
			.when()
				.body(multiplyRequestBody)
				.post("http://www.dneonline.com/calculator.asmx")
			
			.then()
				.statusCode(200)
				.log().all()
				.header("Content-Type", "text/xml; charset=utf-8")
				.time(Matchers.lessThan(3000L));
				System.out.println("Multiplication SOAP API test execution is Completed");
	}
	
	@Feature("DIVISION-SOAP API")
	@Description("This is a SOAP API that uses POST http method")
	@Story("As a user, I can divide 2 integers to get divideResult")
	@Severity(SeverityLevel.CRITICAL)
	@Test (priority = 4)
	public void divideSOAPapi() throws IOException {
		
		File file = new File("./src/test/resources/divideSOAPapiRequestBody.xml");	// establishing connection to the file location
		FileInputStream fileInputStream = new FileInputStream(file);	// reading the file content
		String divideRequestBody = IOUtils.toString(fileInputStream, "UTF-8");
		
			given()
				.header("Content-Type", "text/xml; charset=utf-8")
				.header("SOAPAction", "http://tempuri.org/Divide")
			
			.when()
				.body(divideRequestBody)
				.post("http://www.dneonline.com/calculator.asmx")
			
			.then()
				.statusCode(200)
				.log().all()
				.header("Content-Type", "text/xml; charset=utf-8")
				.time(Matchers.lessThan(3000L));
				System.out.println("Division SOAP API test execution is Completed");
	}	
}