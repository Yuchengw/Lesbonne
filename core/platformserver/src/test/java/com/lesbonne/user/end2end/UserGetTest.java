package test.java.com.lesbonne.user.end2end;

import org.junit.Test;
import org.junit.Before;

import test.java.com.lesbonne.BaseRestApiTest;

import com.lesbonne.user.UserRestURIConstants;

import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.equalTo;

import com.jayway.restassured.RestAssured;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class UserGetTest extends BaseRestApiTest {

	@Before
	public void setUP() {
		super.setUP();
		RestAssured.basePath = "/platform/v1/user/email";
	}

	@Test
	public void testGetAExistUser() {
		// expect().body("userPassword", equalTo("1234"))
		// .when()
		// .get("http://localhost:8092/platform/v1/user/email/test1@test.com");
		given().contentType("application/json").when().get("/test1@test.com/")
				.then().statusCode(200).body("userPassword", equalTo("1234"));
		// expect().
		// statusCode(200).
		// body(
		// "success", equalTo(true),
		// "userInfo.userId", equalTo("wadexu"),
		// "userInfo.firstName", equalTo("Wade"),
		// "userInfo.lastName", equalTo("Xu"),
		// "error", equalTo(null)).
		// when().
		// get("/user/login?userName=wadexu&password=NzrmRcIfIW4=");
	}

	@Test
	public void testGetANonExistUser() {
		// given().param("q",
		// "java8").when().get("/search").then().body("count", equalTo(2));
	}
}
