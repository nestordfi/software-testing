package com.amigoscode.testing.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PhoneNumberValidatorTest {
	
	private PhoneNumberValidator underTest;
	
	@BeforeEach
	void setUp() {
		underTest = new PhoneNumberValidator();
	}
	
	@ParameterizedTest
	@CsvSource({
		"+593960785641,TRUE",
		"+59396078564165123266,FALSE",
		"593960785641,FALSE",
		})
	void isShouldValidatePhoneNumber(String phoneNumber, String expected) {

		//When
		boolean isValid = underTest.test(phoneNumber);
		//Then
		assertEquals(isValid, Boolean.valueOf(expected));
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
