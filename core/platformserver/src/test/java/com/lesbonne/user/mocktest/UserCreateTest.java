package com.lesbonne.user.mocktest;

import com.jayway.restassured.http.ContentType;

import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletResponse;

import com.lesbonne.user.User;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Test Create User
 * 
 * @author jassica
 *
 */
public class UserCreateTest extends BaseRestUserControllerTest {

	@Override
	public String getBaseTestURI() {
		return URLPREFIX + "create";
	}

	@Test
	public void testAddUserPositive() {
		// create a simple user with just email and password
		User testUser = new User();
		testUser.setUserEmail(TEST_EMAIL);
		testUser.setUserPassword(TEST_PASSWORD);

		// create a simple user for persistent user return call
		User resultUser = new User();
		resultUser.setUserEmail(TEST_EMAIL);
		resultUser.setUserPassword(TEST_PASSWORD);

		resultUser.setUserId(TEMP_Key);

		// Testing user with existing email, return true.
		Mockito.when(userService.persistUser((User) Matchers.anyObject()))
				.thenReturn(resultUser);
		Mockito.when(userService.existsUserByEmail(TEST_EMAIL)).thenReturn(
				false);

		given().body(testUser).contentType(ContentType.JSON).when()
				.post(getBaseTestURI()).then()
				.statusCode(HttpServletResponse.SC_OK)
				.contentType(ContentType.JSON)
				.body("userId", equalTo(TEMP_Key));
	}

	@Test
	public void testAddUserWithoutEmail() {
		User testUser = new User();
		testUser.setUserEmail(TEST_EMAIL);

		given().body(testUser).contentType(ContentType.JSON).when()
				.post(URLPREFIX + "create").then()
				.statusCode(HttpServletResponse.SC_BAD_REQUEST);
	}

	@Test
	public void testAddUserWithoutPassword() {
		User testUser = new User();
		testUser.setUserPassword(TEST_PASSWORD);

		given().body(testUser).contentType(ContentType.JSON).when()
				.post(URLPREFIX + "create").then()
				.statusCode(HttpServletResponse.SC_BAD_REQUEST);
	}

	@Test
	public void testAddUserWhereAUserAlreadyExists() {
		// create a simple user with just email and password
		User testUser = new User();
		testUser.setUserEmail(TEST_EMAIL);
		testUser.setUserPassword(TEST_PASSWORD);

		org.mockito.Mockito.when(userService.existsUserByEmail(TEST_EMAIL))
				.thenReturn(true);

		given().body(testUser).contentType(ContentType.JSON).when()
				.post(URLPREFIX + "create").then()
				.statusCode(HttpServletResponse.SC_NOT_ACCEPTABLE);
	}

}
