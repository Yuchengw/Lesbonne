package test.java.com.lesbonne.promotioncode.mocktest;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.equalTo;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import com.jayway.restassured.http.ContentType;
import com.lesbonne.promotion.PromotionCode;
import com.lesbonne.user.User;

/**
 * The create test for the PromotionCodeService
 * @author jassica
 *
 */
public class PromotionCodeCreateTest extends BaseRestPromotionCodeControllerTest{

    @Override
    public String getBaseTestURI() {
        return URLPREFIX + "create";
    }
    
    @Test
    public void testCreatePromotionCodePositive() {
        User testUser = new User();
        testUser.setUserId("001*");

        PromotionCode code = new PromotionCode();
        code.setPromotionCodeValue(PROMOTIONCODE_VALUE);
        code.setOwner(testUser);
        
        PromotionCode result = new PromotionCode();
        result.setPromotionCodeId(TEMP_KEY);

        Mockito.when(promotionCodeService.persistPromotionCode((PromotionCode) Matchers.anyObject()))
                .thenReturn(result);
        given().body(code).contentType(ContentType.JSON).when()
                .post(getBaseTestURI()).then()
                .statusCode(HttpServletResponse.SC_OK)
                .contentType(ContentType.JSON)
                .body("promotionCodeId", equalTo(TEMP_KEY));
    }
}
