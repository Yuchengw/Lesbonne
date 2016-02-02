package test.java.com.lesbonne.sharingpost.mocktest;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.equalTo;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import com.jayway.restassured.http.ContentType;
import com.lesbonne.sharingpost.SharingPost;
import com.lesbonne.user.User;

/**
 * The create test for the SharingPostService
 * @author jassica
 *
 */
public class SharingPostCreateTest extends BaseRestSharingPostControllerTest{

    @Override
    public String getBaseTestURI() {
        return URLPREFIX + "create";
    }
    
    @Test
    public void testCreateSharingPostPositive() {
        User testUser = new User();
        testUser.setUserId("001*");

        SharingPost post = new SharingPost();
        post.setSharingPostSubject(SUBJECT);
        post.setOwner(testUser);
        post.setCategory(CATEGORY);
        
        SharingPost postResult = new SharingPost();
        postResult.setSharingPostId(TEMP_KEY);

        // Testing user with existing email, return true.
        Mockito.when(sharingPostService.persistSharingPost((SharingPost) Matchers.anyObject()))
                .thenReturn(postResult);
        given().body(post).contentType(ContentType.JSON).when()
                .post(getBaseTestURI()).then()
                .statusCode(HttpServletResponse.SC_OK)
                .contentType(ContentType.JSON)
                .body("sharingPostId", equalTo(TEMP_KEY));
    }
}
