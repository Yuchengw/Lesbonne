package test.java.com.lesbonne.paymentmethod.mocktest;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.equalTo;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import com.jayway.restassured.http.ContentType;
import com.lesbonne.paymentmethod.CreditCard;
import com.lesbonne.paymentmethod.PaymentMethod;
import com.lesbonne.user.User;

/**
 * The create test for the PaymentMethodService
 * @author jassica
 *
 */
public class PaymentMethodCreateTest extends BaseRestPaymentMethodControllerTest{

    @Override
    public String getBaseTestURI() {
        return URLPREFIX + "create";
    }
    
    @Test
    public void testCreatePaymentMethodPositive() {
//        User testUser = new User();
//        testUser.setUserId("001*");

        PaymentMethod payment1 = new PaymentMethod();
        payment1.setPaymentType(1);
        payment1.setColumn1("1111222233334444");
        payment1.setColumn2("12");
        payment1.setColumn3("2020");
        payment1.setColumn4("222");
        payment1.setColumn5("visa");
        
        PaymentMethod paymentResult = new PaymentMethod();
        paymentResult.setPaymentMethodId(TEMP_KEY);

        // Testing user with existing email, return true.
        Mockito.when(paymentMethodService.persistPaymentMethod((PaymentMethod) Matchers.anyObject()))
                .thenReturn(paymentResult);
        given().body(payment1).contentType(ContentType.JSON).when()
                .post(getBaseTestURI()).then()
                .statusCode(HttpServletResponse.SC_OK)
                .contentType(ContentType.JSON)
                .body("paymentMethodId", equalTo(TEMP_KEY));
    }
    
    @Test
    public void testCreateCreditCardPositive() {
//        User testUser = new User();
//        testUser.setUserId("001*");

        CreditCard payment1 = new CreditCard();
        payment1.setCardNumber("1111222233334444");
        payment1.setExpireMonth("12");
        payment1.setExpireYear("2020");
        payment1.setCVC("222");
        payment1.setCardType("visa");
        
        CreditCard paymentResult = new CreditCard();
        paymentResult.setPaymentMethodId(TEMP_KEY);

        // Testing user with existing email, return true.
        Mockito.when(paymentMethodService.persistPaymentMethod((CreditCard) Matchers.anyObject()))
                .thenReturn(paymentResult);
        given().body(payment1).contentType(ContentType.JSON).when()
                .post("/platform/v1/creditcard/create").then()
                .statusCode(HttpServletResponse.SC_OK)
                .contentType(ContentType.JSON)
                .body("paymentMethodId", equalTo(TEMP_KEY));
    }
}
