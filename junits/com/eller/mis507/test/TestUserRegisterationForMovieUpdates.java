package com.eller.mis507.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.eller.mis507.userRegistration.UserRegisterationFromTheFile;
import com.eller.mis507.userRegistration.UserRegisterationTemplate;

public class TestUserRegisterationForMovieUpdates {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUserRegisteration() {
		UserRegisterationTemplate userRegisterationTemplate = new UserRegisterationFromTheFile();
		boolean userSuccessfullyRegistered;
		userSuccessfullyRegistered = userRegisterationTemplate.register("userName","movieName");
		assertTrue(userSuccessfullyRegistered);
	}

}
