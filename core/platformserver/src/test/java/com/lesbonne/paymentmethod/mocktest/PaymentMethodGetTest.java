package test.java.com.lesbonne.paymentmethod.mocktest;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.equalTo;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import com.jayway.restassured.http.ContentType;
import com.lesbonne.paymentmethod.PaymentMethod;
import com.lesbonne.user.User;

/**
 * The get service  test for the PaymentMethodService
 * @author jassica
 *
 */
public class PaymentMethodGetTest extends BaseRestPaymentMethodControllerTest{

    @Override
    public String getBaseTestURI() {
        return URLPREFIX + "getPaymentMethodById/";
    }
    
    @Test
    public void testGetPostByIdBasicPositive() {
        User testUser = new User();
        testUser.setUserId("001*");
        
        PaymentMethod payment1 = new PaymentMethod();
        payment1.setPaymentType(1);
        payment1.setColumn1("1111222233334444");
        payment1.setColumn2("12");
        payment1.setColumn3("2020");
        payment1.setColumn4("222");
        payment1.setColumn5("visa");
        payment1.setOwner(testUser);
        
        Mockito.when(paymentMethodService.getPaymentMethodById(TEMP_KEY)).thenReturn(payment1);

        given().when().get(getBaseTestURI() + TEMP_KEY)
                .then().statusCode(HttpServletResponse.SC_OK)
                .contentType(ContentType.JSON).body("column1", equalTo("1111222233334444"));
    }
}
