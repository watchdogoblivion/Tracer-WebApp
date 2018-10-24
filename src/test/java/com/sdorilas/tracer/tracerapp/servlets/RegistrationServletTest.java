package com.sdorilas.tracer.tracerapp.servlets;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.sdorilas.tracer.tracerapp.dto.User;

public class RegistrationServletTest {
	
    private User user;

    @Before
    public void setUp() {
        user = new User("test", "Samuel", "Dorilas", "test2@test.com", "");
    }
	
	@Test
	public void userNameRegexTest() {
		String regex = "[A-Za-z0-9]{1,32}";
		assertTrue(user.getUsername().matches(regex));
	}

	@Test
	public void firstNameRegexTest() {
		String regex = "[A-Za-z-']{1,20}";
		assertTrue(user.getFirstName().matches(regex));
	}

	@Test
	public void lastNameRegexTest() {
		String regex = "[A-Za-z-']{1,20}";
		assertTrue(user.getLastName().matches(regex));
	}
	
	@Test
	public void emailRegexTest() {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		assertTrue(user.getEmail().matches(regex));
	}
	
	@Test
	public void passwordRegexTest() {
		String regex = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])\\w{6,}";
		assertTrue("9Sounds".matches(regex));
		assertFalse("9sounds".matches(regex));
		assertFalse("9SOUNDS".matches(regex));
		assertFalse("Sounds".matches(regex));
		assertFalse("9Soun".matches(regex));
	}

}
