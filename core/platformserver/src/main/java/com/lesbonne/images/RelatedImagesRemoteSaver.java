package com.lesbonne.images;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * The helper method to help save the image to the remote server
 * 
 * @author jassica
 *
 */
public class RelatedImagesRemoteSaver {
	private final String FILE_DIVIDER = System.getProperty("file.separator");

	/**
	 * The file location will be something like
	 * images/[year]/[month]/[date]/[hour]/[minute]/filename The reason for the
	 * format should be found under spike document
	 * 
	 * @param fileName
	 * @return
	 */
	public String createdNewRemotePath(String fileName) {
		Calendar cal = Calendar.getInstance();
		StringBuilder imageRemoteLocation = new StringBuilder("images"
				+ FILE_DIVIDER);
		imageRemoteLocation.append(cal.get(Calendar.YEAR)).append(FILE_DIVIDER);
		imageRemoteLocation.append(cal.get(Calendar.MONTH) + 1).append(
				FILE_DIVIDER);
		imageRemoteLocation.append(cal.get(Calendar.DATE)).append(FILE_DIVIDER);
		imageRemoteLocation.append(cal.get(Calendar.HOUR_OF_DAY)).append(
				FILE_DIVIDER);
		imageRemoteLocation.append(cal.get(Calendar.MINUTE)).append(
				FILE_DIVIDER);
		imageRemoteLocation.append(fileName);
		return imageRemoteLocation.toString();
	}

	/**
	 * Before production, all the pictures will save locally
	 * 
	 * @param path
	 * @param file
	 */
	public void saveToRemoteServer(String path, MultipartFile file) {
		// String osname = System.getProperty("os.name", "").toLowerCase();
		String homeDir = System.getProperty("user.home");
		File outputFile = new File(homeDir, path);
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), outputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
