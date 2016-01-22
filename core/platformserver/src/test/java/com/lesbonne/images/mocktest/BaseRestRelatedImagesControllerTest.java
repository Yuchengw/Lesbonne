package test.java.com.lesbonne.images.mocktest;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.lesbonne.images.RelatedImagesService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:**/LesbonnePlatformDispatcher-servlet.xml",
		"file:**/platform-context.xml", "file:**/test-context.xml" })
@WebAppConfiguration
/**
 * Base Test Class for the RestRelatedImagesController
 * Setup the webApplicationContext and relatedImageService
 * @author jassica
 *
 */
public abstract class BaseRestRelatedImagesControllerTest {
	protected RelatedImagesService relatedImagesService;
	protected static final String URLPREFIX = "/platform/v1/images/";

	@Autowired
	protected WebApplicationContext context;
	
	@Before
	public void setUp() {
		relatedImagesService = (RelatedImagesService) context.getBean("relatedImagesService");
		RestAssuredMockMvc.mockMvc = MockMvcBuilders
				.webAppContextSetup(context).build();
	}
	
	public abstract String getBaseTestURI();
}
