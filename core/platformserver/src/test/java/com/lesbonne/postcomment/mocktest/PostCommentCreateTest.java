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
 * The create test for the PostCommentService
 * @author jassica
 *
 */
public class PostCommentCreateTest extends BaseRestPostCommentControllerTest{

    @Override
    public String getBaseTestURI() {
        return URLPREFIX + "create";
    }
    
    @Test
    public void testCreatePostCommentPositive() {
        User testUser = new User();
        testUser.setUserId("001*");

        SharingPost post = new SharingPost();
        post.setSharingPostId("00s*");
        
        PostComment comment = new PostComment();
        comment.setCommentBody(COMMENT_BODY);;
        comment.setOwner(testUser);
        comment.setSharingPost(post);
        
        PostComment result = new PostComment();
        result.setPostCommentId(TEMP_KEY);

        Mockito.when(postCommentService.persistPostComment((PostComment) Matchers.anyObject()))
                .thenReturn(result);
        given().body(comment).contentType(ContentType.JSON).when()
                .post(getBaseTestURI()).then()
                .statusCode(HttpServletResponse.SC_OK)
                .contentType(ContentType.JSON)
                .body("postCommentId", equalTo(TEMP_KEY));
    }
}
