package test.java.com.lesbonne.postcomment.mocktest;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.equalTo;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import com.jayway.restassured.http.ContentType;
import com.lesbonne.askingpost.AskingPost;
import com.lesbonne.postcomment.PostComment;
import com.lesbonne.sharingpost.SharingPost;
import com.lesbonne.user.User;

/**
 * The get service  test for the PostCommentService
 * @author jassica
 *
 */
public class PostCommentGetTest extends BaseRestPostCommentControllerTest{

    @Override
    public String getBaseTestURI() {
        return URLPREFIX + "getPostCommentById/";
    }
    
    @Test
    public void testGetPostByIdBasicPositive() {
        User testUser = new User();
        testUser.setUserId("001*");

        SharingPost post = new SharingPost();
        post.setSharingPostId("00s*");
        
        PostComment comment = new PostComment();
        comment.setCommentBody(COMMENT_BODY);;
        comment.setOwner(testUser);
        comment.setSharingPost(post);
        
        Mockito.when(postCommentService.getPostCommentById(TEMP_KEY)).thenReturn(comment);

        given().when().get(getBaseTestURI() + TEMP_KEY)
                .then().statusCode(HttpServletResponse.SC_OK)
                .contentType(ContentType.JSON).body("commentBody", equalTo(COMMENT_BODY));
    }
}
