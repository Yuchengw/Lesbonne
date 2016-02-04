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
 * The get service  test for the SharingPostService
 * @author jassica
 *
 */
public class SharingPostGetTest extends BaseRestSharingPostControllerTest{

    @Override
    public String getBaseTestURI() {
        return URLPREFIX + "getSharingPostById/";
    }
    
    @Test
    public void testGetPostByIdBasicPositive() {
        User testUser = new User();
        testUser.setUserId("001*");
        
        SharingPost post = new SharingPost();
        post.setSharingPostSubject(SUBJECT);
        post.setOwner(testUser);
        post.setCategory(CATEGORY);
        
        Mockito.when(sharingPostService.getSharingPostById(TEMP_KEY)).thenReturn(post);

        given().when().get(getBaseTestURI() + TEMP_KEY)
                .then().statusCode(HttpServletResponse.SC_OK)
                .contentType(ContentType.JSON).body("sharingPostSubject", equalTo(SUBJECT));
    }
}
