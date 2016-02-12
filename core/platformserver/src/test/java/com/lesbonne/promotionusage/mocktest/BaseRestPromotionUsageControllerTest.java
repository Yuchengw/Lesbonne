package test.java.com.lesbonne.promotionusage.mocktest;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.lesbonne.promotionusage.PromotionUsageService;

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
public abstract class BaseRestPromotionUsageControllerTest {
    protected PromotionUsageService promotionUsageService;
    protected static final String URLPREFIX = "/platform/v1/promotionusage/";
    
    final String TEMP_KEY = "0pu*";
    final int USAGE_NUMBER = 2;
    
    @Autowired
    protected WebApplicationContext context;
    
    @Before
    public void setUp() {
        promotionUsageService = (PromotionUsageService) context.getBean("promotionUsageService");
        RestAssuredMockMvc.mockMvc = MockMvcBuilders
                .webAppContextSetup(context).build();
    }
    
    public abstract String getBaseTestURI();
}
