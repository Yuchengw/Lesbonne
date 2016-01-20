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
 * @author Jassica
 * @since 1
 * */
public class UserGetTest extends BaseRestUserControllerTest {

	@Test
	public void testExistsUserByEmailBasicPositive() {
		// Fake the userService call on existsUserByEmail
		// return true all the time if the input is TESTEMAIL
		Mockito.when(userService.existsUserByEmail(TEST_EMAIL)).thenReturn(true);

		given().when().get(URLPREFIX + "existsUserByEmail" + "/" + TEST_EMAIL)
				.then().statusCode(HttpServletResponse.SC_OK)
				.contentType("application/json").body(equalTo("true"));

		// Testing user with non-existing email, return false
		org.mockito.Mockito.when(userService.existsUserByEmail(TEST_EMAIL))
				.thenReturn(false);

		given().when().get(URLPREFIX + "existsUserByEmail" + "/" + TEST_EMAIL)
				.then().statusCode(HttpServletResponse.SC_OK)
				.contentType("application/json").body(equalTo("false"));
	}

	@Test
	public void testNoExistsUserByEmailWithANoExistUser() {
		// Fake the userService call on existsUserByEmail
		// return false all the time if the input is TESTEMAIL
		Mockito.when(userService.existsUserByEmail(TEST_EMAIL))
				.thenReturn(false);

		given().when().get(URLPREFIX + "existsUserByEmail" + "/" + TEST_EMAIL)
				.then().statusCode(HttpServletResponse.SC_OK)
				.contentType("application/json").body(equalTo("false"));
	}

	@Override
	public String getBaseTestURI() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Test
//	public void testGetAExistUser() {
//		// expect().body("userPassword", equalTo("1234"))
//		// .when()
//		// .get("http://localhost:8092/platform/v1/user/email/test1@test.com");
//		given().contentType("application/json").when().get("/test1@test.com/")
//				.then().statusCode(200).body("userPassword", equalTo("1234"));
//		// expect().
//		// statusCode(200).
//		// body(
//		// "success", equalTo(true),
//		// "userInfo.userId", equalTo("wadexu"),
//		// "userInfo.firstName", equalTo("Wade"),
//		// "userInfo.lastName", equalTo("Xu"),
//		// "error", equalTo(null)).
//		// when().
//		// get("/user/login?userName=wadexu&password=NzrmRcIfIW4=");
//	}
//
//	@Test
//	public void testGetANonExistUser() {
//		// given().param("q",
//		// "java8").when().get("/search").then().body("count", equalTo(2));
//	}
}
