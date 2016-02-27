package test.java.com.lesbonne.order.mocktest;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.lesbonne.order.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:**/LesbonnePlatformDispatcher-servlet.xml",
        "file:**/platform-context.xml", "file:**/test-context.xml" })
@WebAppConfiguration
/**
 * Base Test Class for the RestOrderController
 * Setup the webApplicationContext and RestSharingService
 * @author jassica
 *
 */
public abstract class BaseRestOrderControllerTest {
    protected OrderService orderService;
    protected static final String URLPREFIX = "/platform/v1/order/";
    
    final double UNIT_PRICE = 9.99;
    final int QUANTITY = 10;
    final String TEMP_KEY = "00d*";
    
    @Autowired
    protected WebApplicationContext context;
    
    @Before
    public void setUp() {
        orderService = (OrderService) context.getBean("orderService");
        RestAssuredMockMvc.mockMvc = MockMvcBuilders
                .webAppContextSetup(context).build();
    }
    
    public abstract String getBaseTestURI();
}
