package com.lesbonne.restapi;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletResponse;

import com.lesbonne.user.UserService;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = {"file:**/LesbonnePlatformDispatcher-servlet.xml",
								    "file:**/platform-context.xml",
								    "file:**/test-context.xml"})
@WebAppConfiguration
/**
 * @author yucheng
 * @since 1
 * */
public class UserControllerTest {
	
    private UserService userService;
    private static final String URLPREFIX = "/platform/v1/user/";
    private static final String TESTEMAIL = "user@test";
    
    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        userService = (UserService) context.getBean("userService");
        RestAssuredMockMvc.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    
    @Test
    /**
     * 
     * */
    public void testExistsUserByEmailWithValidInput() {
    	// Testing user with existing email, return true.
    	org.mockito.Mockito.
        when(userService.existsUserByEmail(TESTEMAIL)).
        thenReturn(true);
    	
    	given().
        when().
        	get (URLPREFIX + "existsUserByEmail" + "/" + TESTEMAIL).
        then().
        statusCode (HttpServletResponse.SC_OK).
        contentType ("application/json").
        body(equalTo("true"));
    	
    	// Testing user with non-existing email, return false
    	org.mockito.Mockito.
    	when(userService.existsUserByEmail(TESTEMAIL)).
    	thenReturn(false);
    	
    	given().
        when().
        	get (URLPREFIX + "existsUserByEmail" + "/" + TESTEMAIL).
        then().
        statusCode (HttpServletResponse.SC_OK).
        contentType ("application/json").
        body(equalTo("false"));
    }
}
