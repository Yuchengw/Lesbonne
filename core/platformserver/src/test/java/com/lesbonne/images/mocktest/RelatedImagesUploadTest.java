package test.java.com.lesbonne.images.mocktest;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Calendar;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import com.jayway.restassured.http.ContentType;
import com.lesbonne.images.RelatedImages;
import com.lesbonne.images.RelatedImagesRemoteSaver;

/**
 * Related imaged upload tests
 * 
 * @author jassica
 *
 */
public class RelatedImagesUploadTest extends
		BaseRestRelatedImagesControllerTest {

	@Override
	public String getBaseTestURI() {
		return URLPREFIX + "create";
	}

	@Test
	public void testCreatedNewRemotePath() {
		RelatedImagesRemoteSaver remoteSaver = new RelatedImagesRemoteSaver();
		String remoteFileLocation = remoteSaver
				.createdNewRemotePath("TestFile.txt");
		Calendar cal = Calendar.getInstance();
		final String FILE_DIVIDER = System.getProperty("file.separator");
		assertTrue(
				"Expect remote file location to be divided by year, month, date, hour",
				remoteFileLocation.contains(cal.get(Calendar.YEAR)
						+ FILE_DIVIDER + (cal.get(Calendar.MONTH) + 1)
						+ FILE_DIVIDER + cal.get(Calendar.DATE)));
	}

	@Test
	public void testUploadImagePositive() {
		RelatedImages document = new RelatedImages();
		document.setName(TEST_NAME);
		Mockito.doNothing().when(relatedImagesService)
				.persistRelatedImages((RelatedImages) Matchers.anyObject());

		given().multiPart(
				new File("src" + File.separator + "test" + File.separator
						+ "java/com/lesbonne/images/mocktest" + File.separator
						+ TEST_NAME)).when().post(getBaseTestURI()).then()
				.statusCode(HttpServletResponse.SC_OK)
				.contentType(ContentType.JSON)
				.body("name", equalTo("TestFile.txt"));
	}

	@Test
	public void testUploadImagePositiveWithMock() {
		Mockito.doNothing().when(relatedImagesService)
				.persistRelatedImages((RelatedImages) Matchers.anyObject());

		given().multiPart("file", TEST_NAME,
				new ByteArrayInputStream("Something Test File".getBytes()))
				.when().post(getBaseTestURI()).then()
				.statusCode(HttpServletResponse.SC_OK)
				.contentType(ContentType.JSON).body("name", equalTo(TEST_NAME));
	}

}
