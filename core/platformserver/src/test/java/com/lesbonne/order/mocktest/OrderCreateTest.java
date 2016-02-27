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
import com.lesbonne.postcomment.PostComment;
import com.lesbonne.sharingpost.SharingPost;
import com.lesbonne.user.User;

/**
 * The create test for the OrderService
 * @author jassica
 *
 */
public class OrderCreateTest extends BaseRestOrderControllerTest{

    @Override
    public String getBaseTestURI() {
        return URLPREFIX + "create";
    }
    
    @Test
    public void testCreateOrderPositive() {
        User testUser = new User();
        testUser.setUserId("001*");

        SharingPost post = new SharingPost();
        post.setSharingPostId("00s*");
        
        Order order = new Order();
        order.setQuantity(QUANTITY);
        order.setUnitPrice(UNIT_PRICE);
        order.setOwner(testUser);
        order.setSharingPost(post);
        
        Order result = new Order();
        result.setOrderId(TEMP_KEY);

        Mockito.when(orderService.persistOrder((Order) Matchers.anyObject()))
                .thenReturn(result);
        given().body(order.toString()).contentType(ContentType.JSON).when()
                .post(getBaseTestURI()).then()
                .statusCode(HttpServletResponse.SC_OK)
                .contentType(ContentType.JSON)
                .body("orderId", equalTo(TEMP_KEY));
    }
    
    @Test
    public void testCreateOrderFailWhenNoParentIsSet() {
        User testUser = new User();
        testUser.setUserId("001*");
        
        Order order = new Order();
        order.setQuantity(QUANTITY);
        order.setUnitPrice(UNIT_PRICE);
        order.setOwner(testUser);

        given().body(order.toString()).contentType(ContentType.JSON).when()
                .post(getBaseTestURI()).then()
                .statusCode(HttpServletResponse.SC_BAD_REQUEST);
    }
    
    @Test
    public void testCreateOrderFailWhenBothParentIsSet() {
        User testUser = new User();
        testUser.setUserId("001*");

        SharingPost post = new SharingPost();
        post.setSharingPostId("00s*");
        
        AskingPost askPost = new AskingPost();
        askPost.setAskingPostId("00a*");
        
        Order order = new Order();
        order.setQuantity(QUANTITY);
        order.setUnitPrice(UNIT_PRICE);
        order.setOwner(testUser);
        order.setAskingPost(askPost);
        order.setSharingPost(post);
        
        given().body(order.toString()).contentType(ContentType.JSON).when()
                .post(getBaseTestURI()).then()
                .statusCode(HttpServletResponse.SC_BAD_REQUEST);
    }
}
