package com.project1.restapi;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class TC09_IntroToJavaFakerLibrary {
	
	@Test
	public void fakerLibrary() {
		
		Faker faker = new Faker();
		System.out.println("Random First Name >> "+faker.name().firstName());
		System.out.println("Random Address >> "+faker.address().fullAddress());
		System.out.println("Random Country Currency >> "+faker.country().currency());
		System.out.println("Random Gender >> "+faker.demographic().sex());
		System.out.println("Random Email address >> "+faker.internet().emailAddress());
	}
}