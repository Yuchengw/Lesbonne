package test.java.com.lesbonne;

import org.junit.Test;
import org.junit.Before;

import com.lesbonne.user.UserRestURIConstants;

import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.equalTo;

public class SampleTest {

	@Test
	public void simpleExample() {
		expect().body("userPassword", equalTo("1234")).when()
				.get("http://localhost:8092/platform/v1/user/test1@test.com");
	}
}
