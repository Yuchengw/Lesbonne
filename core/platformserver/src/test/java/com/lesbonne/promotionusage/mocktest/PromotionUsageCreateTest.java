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
 * The create test for the PromotionUsageService
 * @author jassica
 *
 */
public class PromotionUsageCreateTest extends BaseRestPromotionUsageControllerTest{

    @Override
    public String getBaseTestURI() {
        return URLPREFIX + "create";
    }
    
    @Test
    public void testCreatePromotionUsagePositive() {
        User testUser = new User();
        testUser.setUserId("001*");

        PromotionCode code = new PromotionCode();
        code.setPromotionCodeId("0pc*");
        
        com.lesbonne.promotionusage.PromotionUsage usage = new PromotionUsage();
        usage.setUsage(USAGE_NUMBER);;
        usage.setUsedBy(testUser);
        usage.setPromotionCode(code);
        
        PromotionUsage result = new PromotionUsage();
        result.setPromotionUsageId(TEMP_KEY);

        Mockito.when(promotionUsageService.persistPromotionUsage((PromotionUsage) Matchers.anyObject()))
                .thenReturn(result);
        given().body(usage).contentType(ContentType.JSON).when()
                .post(getBaseTestURI()).then()
                .statusCode(HttpServletResponse.SC_OK)
                .contentType(ContentType.JSON)
                .body("promotionUsageId", equalTo(TEMP_KEY));
    }
}
