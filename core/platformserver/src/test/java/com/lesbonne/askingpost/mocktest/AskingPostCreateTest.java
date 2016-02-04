package test.java.com.lesbonne.askingpost.mocktest;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.equalTo;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import com.jayway.restassured.http.ContentType;
import com.lesbonne.askingpost.AskingPost;
import com.lesbonne.sharingpost.SharingPost;
import com.lesbonne.user.User;

/**
 * The create test for the AskingPostService
 * @author jassica
 *
 */
public class AskingPostCreateTest extends BaseRestAskingPostControllerTest{

    @Override
    public String getBaseTestURI() {
        return URLPREFIX + "create";
    }
    
    @Test
    public void testCreateAskingPostPositive() {
        User testUser = new User();
        testUser.setUserId("001*");

        AskingPost post = new AskingPost();
        post.setAskingPostSubject(SUBJECT);
        post.setOwner(testUser);
        post.setCategory(CATEGORY);
        
        AskingPost postResult = new AskingPost();
        postResult.setAskingPostId(TEMP_KEY);

        // Testing user with existing email, return true.
        Mockito.when(askingPostService.persistAskingPost((AskingPost) Matchers.anyObject()))
                .thenReturn(postResult);
        given().body(post).contentType(ContentType.JSON).when()
                .post(getBaseTestURI()).then()
                .statusCode(HttpServletResponse.SC_OK)
                .contentType(ContentType.JSON)
                .body("askingPostId", equalTo(TEMP_KEY));
    }
}
