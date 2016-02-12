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
 * The get service  test for the PromotionCodeService
 * @author jassica
 *
 */
public class PromotionCodeGetTest extends BaseRestPromotionCodeControllerTest{

    @Override
    public String getBaseTestURI() {
        return URLPREFIX + "getPromotionCodeById/";
    }
    
    @Test
    public void testGetPromotionCodeByIdBasicPositive() {
        User testUser = new User();
        testUser.setUserId("001*");
        
        PromotionCode code = new PromotionCode();
        code.setPromotionCodeValue(PROMOTIONCODE_VALUE);
        code.setOwner(testUser);
        
        Mockito.when(promotionCodeService.getPromotionCodeById(TEMP_KEY)).thenReturn(code);

        given().when().get(getBaseTestURI() + TEMP_KEY)
                .then().statusCode(HttpServletResponse.SC_OK)
                .contentType(ContentType.JSON).body("promotionCodeValue", equalTo(PROMOTIONCODE_VALUE));
    }
}
