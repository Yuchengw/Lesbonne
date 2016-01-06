package test.java.com.lesbonne;

import org.junit.Before;

import com.jayway.restassured.RestAssured;

public abstract class BaseRestApiTest {
	@Before
	public void setUP() {
		// Specify URL and port
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8092;
	}
}
