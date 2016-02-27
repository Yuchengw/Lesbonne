package test.java.com.lesbonne.paymentmethod.mocktest;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.lesbonne.paymentmethod.PaymentMethodService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:**/LesbonnePlatformDispatcher-servlet.xml",
        "file:**/platform-context.xml", "file:**/test-context.xml" })
@WebAppConfiguration
/**
 * Base Test Class for the RestPaymentMethodController
 * Setup the webApplicationContext and RestPaymentMethodService
 * @author jassica
 *
 */
public abstract class BaseRestPaymentMethodControllerTest {
    protected PaymentMethodService paymentMethodService;
    protected static final String URLPREFIX = "/platform/v1/paymentmethod/";
    
    final String TEMP_KEY = "0pm*";
    
    @Autowired
    protected WebApplicationContext context;
    
    @Before
    public void setUp() {
        paymentMethodService = (PaymentMethodService) context.getBean("paymentMethodService");
        RestAssuredMockMvc.mockMvc = MockMvcBuilders
                .webAppContextSetup(context).build();
    }
    
    public abstract String getBaseTestURI();
}
