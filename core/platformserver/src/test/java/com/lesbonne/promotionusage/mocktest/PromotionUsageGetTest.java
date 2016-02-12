package test.java.com.lesbonne.promotionusage.mocktest;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.equalTo;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import com.jayway.restassured.http.ContentType;
import com.lesbonne.promotion.PromotionCode;
import com.lesbonne.promotionusage.PromotionUsage;
import com.lesbonne.user.User;

/**
 * The get service  test for the PromotionUsageService
 * @author jassica
 *
 */
public class PromotionUsageGetTest extends BaseRestPromotionUsageControllerTest{

    @Override
    public String getBaseTestURI() {
        return URLPREFIX + "getPromotionUsageById/";
    }
    
    @Test
    public void testGetPostByIdBasicPositive() {
        User testUser = new User();
        testUser.setUserId("001*");

        PromotionCode code = new PromotionCode();
        code.setPromotionCodeId("0pc*");
        
        PromotionUsage usage = new PromotionUsage();
        usage.setUsage(USAGE_NUMBER);;
        usage.setUsedBy(testUser);
        usage.setPromotionCode(code);
        
        Mockito.when(promotionUsageService.getPromotionUsageById(TEMP_KEY)).thenReturn(usage);

        given().when().get(getBaseTestURI() + TEMP_KEY)
                .then().statusCode(HttpServletResponse.SC_OK)
                .contentType(ContentType.JSON).body("usage", equalTo(USAGE_NUMBER));
    }
}
