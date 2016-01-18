package test.java.com.lesbonne.user.mocktest;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.lesbonne.user.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:**/LesbonnePlatformDispatcher-servlet.xml",
		"file:**/platform-context.xml", "file:**/test-context.xml" })
@WebAppConfiguration
/**
 * Base Test Class for the RestUserController
 * Setup the webApplicationContext abnd userservice
 * @author jassica
 *
 */
public abstract class BaseRestUserControllerTest {
	protected UserService userService;
	protected static final String URLPREFIX = "/platform/v1/user/";
	protected static final String TEST_EMAIL = "user@test";
	
	@Autowired
	protected WebApplicationContext context;
	
	@Before
	public void setUp() {
		userService = (UserService) context.getBean("userService");
		RestAssuredMockMvc.mockMvc = MockMvcBuilders
				.webAppContextSetup(context).build();
	}
}