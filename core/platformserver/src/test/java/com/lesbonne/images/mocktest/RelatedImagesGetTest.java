package test.java.com.lesbonne.images.mocktest;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.equalTo;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import com.jayway.restassured.http.ContentType;
import com.lesbonne.images.RelatedImages;

/**
 * Related imaged download tests
 * @author jassica
 *
 */
public class RelatedImagesGetTest extends BaseRestRelatedImagesControllerTest{

	@Override
	public String getBaseTestURI() {
		return URLPREFIX + "id/";
	}

	@Test
	public void testGetUserByIdBasicPositive() {
		RelatedImages image = new RelatedImages();
		image.setName(TEST_NAME);
		Mockito.when(relatedImagesService.getRelatedImagesById(Matchers.anyString())).thenReturn(image);

		given().when().get(getBaseTestURI() + "1")
				.then().statusCode(HttpServletResponse.SC_OK)
				.contentType(ContentType.JSON).body("name", equalTo(TEST_NAME));
	}
}
