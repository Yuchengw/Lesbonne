package test.java.com.lesbonne.order.mocktest;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.equalTo;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import com.jayway.restassured.http.ContentType;
import com.lesbonne.askingpost.AskingPost;
import com.lesbonne.order.Order;
import com.lesbonne.sharingpost.SharingPost;
import com.lesbonne.user.User;

/**
 * The get service  test for the OrderService
 * @author jassica
 *
 */
public class OrderGetTest extends BaseRestOrderControllerTest{

    @Override
    public String getBaseTestURI() {
        return URLPREFIX + "getOrderById/";
    }
    
    @Test
    public void testGetPostByIdBasicPositive() {
        User testUser = new User();
        testUser.setUserId("001*");

        SharingPost post = new SharingPost();
        post.setSharingPostId("00s*");
        
        Order order = new Order();
        order.setQuantity(QUANTITY);
        order.setUnitPrice(UNIT_PRICE);
        order.setOwner(testUser);
        order.setSharingPost(post);
        
        Mockito.when(orderService.getOrderById(TEMP_KEY)).thenReturn(order);

        given().when().get(getBaseTestURI() + TEMP_KEY)
                .then().statusCode(HttpServletResponse.SC_OK)
                .contentType(ContentType.JSON).body("quantity", equalTo(QUANTITY));
    }
}
