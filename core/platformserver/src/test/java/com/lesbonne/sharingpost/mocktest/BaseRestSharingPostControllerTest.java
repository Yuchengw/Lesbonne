package test.java.com.lesbonne.sharingpost.mocktest;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.lesbonne.sharingpost.SharingPostService;

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
public abstract class BaseRestSharingPostControllerTest {
    protected SharingPostService sharingPostService;
    protected static final String URLPREFIX = "/platform/v1/sharingpost/";
    
    final String SUBJECT = "Test Subject";
    final String CATEGORY = "seafood";
    final String TEMP_KEY = "00s*";
    
    @Autowired
    protected WebApplicationContext context;
    
    @Before
    public void setUp() {
        sharingPostService = (SharingPostService) context.getBean("sharingPostService");
        RestAssuredMockMvc.mockMvc = MockMvcBuilders
                .webAppContextSetup(context).build();
    }
    
    public abstract String getBaseTestURI();
}
