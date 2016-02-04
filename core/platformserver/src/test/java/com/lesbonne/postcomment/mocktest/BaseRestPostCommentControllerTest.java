package test.java.com.lesbonne.postcomment.mocktest;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.lesbonne.askingpost.AskingPostService;
import com.lesbonne.postcomment.PostCommentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:**/LesbonnePlatformDispatcher-servlet.xml",
        "file:**/platform-context.xml", "file:**/test-context.xml" })
@WebAppConfiguration
/**
 * Base Test Class for the RestSharingPostController
 * Setup the webApplicationContext and RestSharingService
 * @author jassica
 *
 */
public abstract class BaseRestPostCommentControllerTest {
    protected PostCommentService postCommentService;
    protected static final String URLPREFIX = "/platform/v1/postcomment/";
    
    final String COMMENT_BODY = "Test COMMENT BODY";
    final String TEMP_KEY = "00c*";
    
    @Autowired
    protected WebApplicationContext context;
    
    @Before
    public void setUp() {
        postCommentService = (PostCommentService) context.getBean("postCommentService");
        RestAssuredMockMvc.mockMvc = MockMvcBuilders
                .webAppContextSetup(context).build();
    }
    
    public abstract String getBaseTestURI();
}
