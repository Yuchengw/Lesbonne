package test.java.com.lesbonne.user.mocktest;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.equalTo;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import com.jayway.restassured.http.ContentType;
import com.lesbonne.user.User;

public class UserUpdateTest extends BaseRestUserControllerTest {

	@Override
	public String getBaseTestURI() {
		return URLPREFIX + "update";
	}
	
	@Test
	public void testUpdateUserPositive() {
		// create a simple user with just email and password
		User testUser = new User();
		testUser.setUserEmail(TEST_EMAIL);
		testUser.setUserPassword(TEST_PASSWORD);
		testUser.setUserId(TEMP_Key);
		Mockito.when(userService.persistUser((User) Matchers.anyObject()))
		.thenReturn(testUser);
		
		// create a simple user for persistent user return call
		User resultUser = new User();
		resultUser.setUserEmail(TEST_EMAIL + "Update");
		resultUser.setUserPassword(TEST_PASSWORD);
		resultUser.setUserId(TEMP_Key);
		Mockito.when(userService.updateUser((User) Matchers.anyObject()))
				.thenReturn(resultUser);
		Mockito.when(userService.existsUserByEmail(TEST_EMAIL)).thenReturn(
				false);

		given().body(testUser).contentType(ContentType.JSON).when()
				.put(getBaseTestURI()).then()
				.statusCode(HttpServletResponse.SC_OK)
				.contentType(ContentType.JSON)
				.body("userEmail", equalTo(TEST_EMAIL + "Update"));
	}
	
	@Test
	public void testUpdateUserWithoutEmail() {
		// create a simple user with just email and password
		User testUser = new User();
		testUser.setUserPassword(TEST_PASSWORD);
		testUser.setUserId(TEMP_Key);
		
		given().body(testUser).contentType(ContentType.JSON).when()
				.put(getBaseTestURI()).then()
				.statusCode(HttpServletResponse.SC_BAD_REQUEST);
	}
	
	@Test
	public void testUpdateUserWithoutPassword() {
		// create a simple user with just email and password
		User testUser = new User();
		testUser.setUserEmail(TEST_EMAIL);
		testUser.setUserId(TEMP_Key);
		
		given().body(testUser).contentType(ContentType.JSON).when()
				.put(getBaseTestURI()).then()
				.statusCode(HttpServletResponse.SC_BAD_REQUEST);
	}
	
	@Test
	public void testUpdateUserWithoutUserid() {
		// create a simple user with just email and password
		User testUser = new User();
		testUser.setUserEmail(TEST_EMAIL);
		testUser.setUserPassword(TEST_PASSWORD);
		
		given().body(testUser).contentType(ContentType.JSON).when()
				.put(getBaseTestURI()).then()
				.statusCode(HttpServletResponse.SC_BAD_REQUEST);
	}
	
	@Test
    public void testDeleteUser() {
        // create a simple user with just email and password
        User testUser = new User();
        testUser.setUserEmail(TEST_EMAIL);
        testUser.setUserPassword(TEST_PASSWORD);
        
        Mockito.doNothing().when(userService).deleteUser((User) Matchers.anyObject());
        
        given().body(testUser).contentType(ContentType.JSON).when()
                .delete(URLPREFIX + "delete").then()
                .statusCode(HttpServletResponse.SC_OK)
                .contentType(ContentType.JSON).body(equalTo("true"));
    }
	
	@Test
    public void testDeleteUserCascade() {
	    // TODO: Add sharing post
//	    User testUser = new User();
//        testUser.setUserEmail(TEST_EMAIL);
//        testUser.setUserPassword(TEST_PASSWORD);
//        
//        Mockito.doNothing().when(userService).deleteUser((User) Matchers.anyObject());
//        
//        given().body(testUser).contentType(ContentType.JSON).when()
//                .delete(URLPREFIX + "delete").then()
//                .statusCode(HttpServletResponse.SC_OK)
//                .contentType(ContentType.JSON).body(equalTo("true"));
    }
}
