package test.java.com.lesbonne.askingpost.mocktest;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.equalTo;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import com.jayway.restassured.http.ContentType;
import com.lesbonne.askingpost.AskingPost;
import com.lesbonne.user.User;

/**
 * The get service  test for the AskingPostService
 * @author jassica
 *
 */
public class AskingPostGetTest extends BaseRestAskingPostControllerTest{

    @Override
    public String getBaseTestURI() {
        return URLPREFIX + "getAskingPostById/";
    }
    
    @Test
    public void testGetPostByIdBasicPositive() {
        User testUser = new User();
        testUser.setUserId("001*");
        
        AskingPost post = new AskingPost();
        post.setAskingPostSubject(SUBJECT);
        post.setOwner(testUser);
        post.setCategory(CATEGORY);
        
        Mockito.when(askingPostService.getAskingPostById(TEMP_KEY)).thenReturn(post);

        given().when().get(getBaseTestURI() + TEMP_KEY)
                .then().statusCode(HttpServletResponse.SC_OK)
                .contentType(ContentType.JSON).body("askingPostSubject", equalTo(SUBJECT));
    }
}
