package test.java.com.lesbonne.user.mocktest;

import org.junit.Test;
import org.mockito.Mockito;

import com.jayway.restassured.http.ContentType;
import com.lesbonne.user.User;

import javax.servlet.http.HttpServletResponse;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @author Jassica
 * @since 1
 * */
public class UserGetTest extends BaseRestUserControllerTest {

	@Test
	public void testExistsUserByEmailBasicPositive() {
		// Fake the userService call on existsUserByEmail
		// return true all the time if the input is TESTEMAIL
		Mockito.when(userService.existsUserByEmail(TEST_EMAIL)).thenReturn(true);

		given().when().get(URLPREFIX + "existsUserByEmail/" + TEST_EMAIL)
				.then().statusCode(HttpServletResponse.SC_OK)
				.contentType(ContentType.JSON).body(equalTo("true"));
	}

	@Test
	public void testExistsUserByEmailWithANoExistUser() {
		// Fake the userService call on existsUserByEmail
		// return false all the time if the input is TESTEMAIL
		Mockito.when(userService.existsUserByEmail(TEST_EMAIL))
				.thenReturn(false);

		given().when().get(URLPREFIX + "existsUserByEmail/" + TEST_EMAIL)
				.then().statusCode(HttpServletResponse.SC_OK)
				.contentType(ContentType.JSON).body(equalTo("false"));
	}

	@Test
	public void testGetUserByEmailBasicPositive() {
		User testUser = new User();
		testUser.setUserEmail(TEST_EMAIL);
		testUser.setUserPassword(TEST_PASSWORD);
		// Fake the userService call on existsUserByEmail
		// return true all the time if the input is TESTEMAIL
		Mockito.when(userService.getUserByEmail(TEST_EMAIL)).thenReturn(testUser);

		given().when().get(URLPREFIX + "getUserByEmail/" + TEST_EMAIL)
				.then().statusCode(HttpServletResponse.SC_OK)
				.contentType(ContentType.JSON).body("userPassword", equalTo(TEST_PASSWORD));
	}
	
	@Test
	public void testGetUserByIdBasicPositive() {
		User testUser = new User();
		testUser.setUserEmail(TEST_EMAIL);
		testUser.setUserPassword(TEST_PASSWORD);
		// Fake the userService call on existsUserByEmail
		// return true all the time if the input is TESTEMAIL
		Mockito.when(userService.getUserById(TEMP_Key)).thenReturn(testUser);

		given().when().get(URLPREFIX + "getUserById/" + TEMP_Key)
				.then().statusCode(HttpServletResponse.SC_OK)
				.contentType(ContentType.JSON).body("userPassword", equalTo(TEST_PASSWORD));
	}

	@Override
	public String getBaseTestURI() {
		// TODO Auto-generated method stub
		return null;
	}
}
