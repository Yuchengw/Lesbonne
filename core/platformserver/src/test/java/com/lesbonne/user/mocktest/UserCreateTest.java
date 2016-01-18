package test.java.com.lesbonne.user.mocktest;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletResponse;

import com.lesbonne.user.User;
import com.lesbonne.user.UserService;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Test Create User
 * @author jassica
 *
 */
public class UserCreateTest extends BaseRestUserControllerTest {

	// @Test
	// public void testCreateANewUser() {
	// User newUser = new User();
	// newUser.setUserEmail("test2@test.com");
	// newUser.setUserPassword("12345678");
	// given().contentType("application/json").request()
	// .body(newUser.toString()).expect().statusCode(200)
	// .body("userPassword", equalTo("12345678")).when().post();
	// }

	private static final String TEST_PASSWORD = "123456";
	private static final String TEMP_Key = "001"; 
	
	@Test
	@Transactional
	public void testCreateANewUserPositive() {
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

		given().body(testUser).contentType(ContentType.JSON).when()
				.post(URLPREFIX + "create").then()
				.statusCode(HttpServletResponse.SC_OK)
				.contentType("application/json").body("userId", equalTo(TEMP_Key));
	}
}
