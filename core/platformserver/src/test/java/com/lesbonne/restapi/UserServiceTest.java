package com.lesbonne.restapi;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Platform test for UserObject
 * 
 * @author Jessica
 * @version 1
 *
 */
public class UserServiceTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public UserServiceTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(UserServiceTest.class);
	}

	/**
	 * Create a new user and save to db
	 * 
	 * @throws Exception
	 */
	public void testCreateNewUser() {
	}

	public void testRemoveExistingUser() throws Exception {
	}
	
	public void testLoadExistingUser() throws Exception {
	}

	public void testUpdateExistingUser() throws Exception {
	}

	public void testIfUserEmailExist() throws Exception {
	}
}
