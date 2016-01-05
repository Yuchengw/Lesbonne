package test.java.com.lesbonne.user;

import org.junit.Test;
import org.junit.Before;

import test.java.com.lesbonne.BaseRestApiTest;

import com.lesbonne.user.User;
import com.lesbonne.user.UserRestURIConstants;

import static org.hamcrest.Matchers.equalTo;

import com.jayway.restassured.RestAssured;

import static com.jayway.restassured.RestAssured.*;

public class UserCreateTest extends BaseRestApiTest {

	@Before
	public void setUP() {
		super.setUP();
		RestAssured.basePath = UserRestURIConstants.CREATE_USER;
	}

	@Test
	public void testCreateANewUser() {
		User newUser = new User();
		newUser.setUserEmail("test2@test.com");
		newUser.setUserPassword("12345678");
		given().contentType("application/json").request()
				.body(newUser.toString()).expect().statusCode(200)
				.body("userPassword", equalTo("12345678")).when().post();
	}

}
