package com.amigoscode.testing.utils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PhoneNumberValidatorTest {
	
	private PhoneNumberValidator underTest;
	
	@BeforeEach
	void setUp() {
		underTest = new PhoneNumberValidator();
	}
	
	@Test
	void isShouldValidatePhoneNumber() {
		//Given
		String phoneNumber = "+593960785641";
		//When
		boolean isValid = underTest.test(phoneNumber);
		//Then
		assertTrue(isValid);
	}
	
	@Test
	@DisplayName("Should fail when length is bigger than 13")
	void isShouldValidatePhoneNumberWhenIncorrectAndHasLengthBiggerThan13() {
		//Given
		String phoneNumber = "+59396078564165123266";
		//When
		boolean isValid = underTest.test(phoneNumber);
		//Then
		assertFalse(isValid);
	}
	
	@Test
	@DisplayName("Should fail when does not start with +")
	void isShouldValidatePhoneNumberWhenDoesNotStartWithPlus() {
		//Given
		String phoneNumber = "593960785641";
		//When
		boolean isValid = underTest.test(phoneNumber);
		//Then
		assertFalse(isValid);
	}

}
