package test.java.com.lesbonne.images.mocktest;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;

import com.jayway.restassured.http.ContentType;
import com.lesbonne.images.RelatedImages;
import com.lesbonne.images.RelatedImagesRemoteSaver;
import com.lesbonne.user.User;

public class RelatedImagesUploadTest extends BaseRestRelatedImagesControllerTest{

	@Override
	public String getBaseTestURI() {
		return URLPREFIX + "create";
	}

	@Test
	public void testCreatedNewRemotePath() {
		RelatedImagesRemoteSaver remoteSaver = new RelatedImagesRemoteSaver();
		String remoteFileLocation = remoteSaver.createdNewRemotePath("TestFile.txt");
		Calendar cal = Calendar.getInstance();
		final String FILE_DIVIDER = System.getProperty("file.separator");
		assertTrue("Expect remote file location to be divided by year, month, date, hour", remoteFileLocation.contains(
				cal.get(Calendar.YEAR) + FILE_DIVIDER + (cal.get(Calendar.MONTH) + 1) + FILE_DIVIDER + cal.get(Calendar.DATE)));
	}
	
	@Test
	public void testUploadImagePositive() {
		RelatedImages document = new RelatedImages();
		document.setName("TestFile.txt");
		Mockito.doNothing().when(relatedImagesService).persistRelatedImages((RelatedImages) Matchers.anyObject());
//		FileInputStream inputFile = new FileInputStream( "path of the file");  
//		MockMultipartFile file = new MockMultipartFile("file", "NameOfTheFile", "multipart/form-data", inputFile);
		byte[] content = "some xml".getBytes();
		MockMultipartFile firstFile = new MockMultipartFile("data", "TestFile.txt", "text/plain", content);
//        MockMultipartFile secondFile = new MockMultipartFile("data", "other-file-name.data", "text/plain", "some other type".getBytes());
//        MockMultipartFile jsonFile = new MockMultipartFile("json", "", "application/json", "{\"json\": \"someValue\"}".getBytes());

//        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//        mockMvc.perform(MockMvcRequestBuilders.fileUpload(getBaseTestURI())
//                        .file(firstFile)
//                        .file(secondFile).file(jsonFile)
//                        .param("some-random", "4"))
//                    .andExpect(status().is(200))
//                    .andExpect(content().string("success"));
        
		File file = new File("newfile.txt");
	      
	      try {
			if (file.createNewFile()){
			    System.out.println("File is created!");
			  }else{
			    System.out.println("File already exists.");
			  }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
		given().multiPart(new File("src" + File.separator + "test"
			    + File.separator + "java/com/lesbonne/images/mocktest" + File.separator + "TestFile.txt"))//new File( RelatedImagesUploadTest.class.getResource("TestFile.txt").getFile()))//.contentType(ContentType.JSON)
		.when()
		.post(getBaseTestURI()).then()
		.statusCode(HttpServletResponse.SC_OK)
		.contentType(ContentType.JSON)
		.body("name", equalTo("TestFile.txt"));
	}
	
	
}
